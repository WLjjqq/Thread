package thread_1.第一章第10小节线程优先级;


/**
 * 设置线程的优先级使用setPriority()的方法。JDK中使用3个常量来预置定义优先级的值。
 *          public final static int MIN_PRIORITY=1;
 *          public final static int NORM_PRIORITY =5;
 *          public final static int MAX_PRIORITY=10;
 * 线程优先级的继承特性
 */
public class MyThread11011 extends Thread{
    public void run(){
        System.out.println("MyThread1 run priority=" +this.getPriority());
        MyThread11012 myThread11012 = new MyThread11012();
        myThread11012.start();
    }

    public static void main(String[] args) {
        System.out.println("main thread begin priority="+Thread.currentThread().getPriority());
        /**
         *  Thread.currentThread().setPriority(7);这句话注解掉。输出的结果
         *  main thread begin priority=5
         * main thread end priority=5
         * MyThread1 run priority=5
         * MyThread2 run priority = 5
         * 去掉注解。  创建线程1。然后线程1里又创建了线程2.所以线程1，线程2的优先级都是7,。
         * main thread begin priority=5
         * main thread end priority=7
         * MyThread1 run priority=7
         * MyThread2 run priority = 7
         */
        Thread.currentThread().setPriority(7);
        System.out.println("main thread end priority=" + Thread.currentThread().getPriority());
        MyThread11011 myThread11011 = new MyThread11011();
        myThread11011.start();
    }
}
