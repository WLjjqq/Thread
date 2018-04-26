package thread_1;

/**
 * 知识点：isAlive()。判断这个线程是否处于活动状态
 * 输出结果：
 * begin = false
 * end = true
 * run= true
 * 在没有启动的时候，start().
 */
public class MyThread_isAlive extends Thread {
    public void run(){
        System.out.println("run= "+this.isAlive());
    }

    public static void main(String[] args) {
        MyThread_isAlive myThread_isAlive = new MyThread_isAlive();
        System.out.println("begin = "+myThread_isAlive.isAlive());
        myThread_isAlive.start();
        System.out.println("end = "+myThread_isAlive.isAlive());
    }
}
