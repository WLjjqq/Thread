package thread_1;

/**
 * 1：使用接口的好处：
 *      因为java是单继承的。但是可以实现多个接口。
 * 2：Thread类中有两个构造函数Thread(Runnable target) 和Thread(Runnable target,String name)。可以传递Runnable接口。相当于是给Runnable开了一个入口。
 * 3： Thread也实现了Runnable接口。意味着Thread(Runnable target)构造函数不光可以传入Runnable接口的对象。还可以传入一个Thread类的对象。
 *      好处：可以将Thread对象中的run()方法交给其他的线程进行调用。
 * 4：start()方法是：通知“线程规划器”，这个线程已经准备好了。请安排时间去调用这个线程。调用这个线程的run()方法。
 *      不能直接thread.run()。这样相当于是调用了一个run()方法。不是调用线程。
 *      run()是线程的主体。
 */
public class MyThreadRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("实现Runnable的方式");
    }
    //使用
    public static void main(String[] args) {
        MyThreadRunnable myThreadRunnable =new MyThreadRunnable();
                Thread thread=new Thread(myThreadRunnable);
                thread.start();
        System.out.println("运行结束！！！");
    }
    /**
     * 输出结果：
     *      运行结束！！！
     *      实现Runnable的方式
     */
}
