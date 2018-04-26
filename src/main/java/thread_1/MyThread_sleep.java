package thread_1;

/**
 * 知识点：在指定的毫秒内，让当前“正在执行的线程”休眠（暂停执行）。“正在执行的线程”，this.currentThread()返回的线程。
 */
public class MyThread_sleep extends Thread {
    public void run(){
        try {
            System.out.println("当前线程："+this.currentThread().getName()+"begin="+System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("当前线程："+this.currentThread().getName()+"end="+System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyThread_sleep myThread_sleep = new MyThread_sleep();
        System.out.println("begin="+System.currentTimeMillis());
        myThread_sleep.start();
        System.out.println("end="+System.currentTimeMillis());
    }
}
