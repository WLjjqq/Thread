package thread_1.守护线程;

/**
 * Java线程中有两种线程，一种是用户线程。另外一种是守护(Daemon)线程。
 * 非守护线程就相当于幼儿园小朋友。守护线程就是老师。当所有的学生都回家了。老师也回家。
 * 最典型的应用：GC(垃圾回收器。)
 */
public class MyThread extends Thread {
    private int i=0;
    public void run(){
        while (true){
            i++;
            System.out.println("i= " +(i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        //把myThread设置为守护线程。
        myThread.setDaemon(true);
        myThread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我离开thread对象也不再打印了，也就是停止了！");
    }
}
