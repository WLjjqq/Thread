package thread_1;

/**
 * 主题：睡眠停止线程。先停止，再遇到sleep
 * 先把线程给停止，然后遇到了sleep。出现异常。
 */
public class MyThread1741 extends Thread {
    public void run(){
        super.run();
        try {
            for(int i=0;i<100000;i++){
                System.out.println("i=" +(i+1));
            }
            System.out.println("run begin");
            Thread.sleep(20000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("先停止，然后遇到sleep,进入catch！ " + this.isInterrupted());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyThread1741 myThread1741 = new MyThread1741();
        myThread1741.start();
        myThread1741.interrupt();
        System.out.println("end");
    }
}
/**
 *输出结果：
 * i=100000
 * run begin
 * 先停止，然后遇到sleep,进入catch！ false
 * java.lang.InterruptedException: sleep interrupted
 * 	at java.lang.Thread.sleep(Native Method)
 * 	at thread_1.MyThread1741.run(MyThread1741.java:14)
 **/