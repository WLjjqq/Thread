package thread_1;

/**
 * 主题：睡眠停止线程。先sleep，再停止
 * 在sleep状态下停止某一线程。进入catch语句，并清除停止状态值。
 * 所说的睡眠停止线程。都是在run()方法中的睡眠。
 */
public class MyThread174 extends Thread {
    public void run(){
        super.run();
        try {
            System.out.println("run begin");
            Thread.sleep(20000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("在沉睡中被停止,进入catch " + this.isInterrupted());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyThread174 myThread174 = new MyThread174();
        myThread174.start();

       try {
             Thread.sleep(2000);
            myThread174.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
/**
 * 输出结果：先睡眠的
 *  run begin
 * end
 * 在沉睡中被停止,进入catch false
 * java.lang.InterruptedException: sleep interrupted
 * 	at java.lang.Thread.sleep(Native Method)
 * 	at thread_1.MyThread174.run(MyThread174.java:11)
 **/