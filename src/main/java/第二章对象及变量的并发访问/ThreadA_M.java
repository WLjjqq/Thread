package 第二章对象及变量的并发访问;

/**
 * 调用关键字synchronized声明的方法一定是排队运行的。
 * 只有共享资源的读写访问才需要同步化。
 */
public class ThreadA_M extends Thread {
    private MyObject myObject;
    public ThreadA_M(MyObject object){
        super();
        this.myObject=object;
    }

    @Override
    public void run() {
        super.run();
        myObject.methodA();
    }

    /**
     * 1：首先都是访问没有synchronized的methodA()方法。
     * 输出结果。
     * begin methodA threadName = A
     * begin methodA threadName = B
     * end
     * end
     * 2：给methodA()方法加上锁synchronized。
     * 输出：
     *begin methodA threadName = A
     * end
     * begin methodA threadName = B
     * end
     * 结论：调用关键字synchronized声明的方法一定是排队运行的。
     * 3：给MyObject中加个methodB方法。没有synchronized修饰。线程B去调用这个方法。
     *   输出：
     *   begin methodA threadName = A
     * begin methodB threadName = B
     * end
     * end
     * 结论：虽然线程A先持有了object对象的锁，但是线程B完全可以异步调用非synchronized类型的方法。
     * 4：给methodB方法也加上锁。
     *   输出：
     *   begin methodB threadName = B
     * end
     * begin methodA threadName = A
     * end
     * 结论：1）：A线程先持有object对象的Lock锁，B线程可以以异步的方式调用object对象中的非synchronized类型的方法。
     *       2）：A线程先持有object对象的Lock锁，B线程如果这时调用object对象中的synchronized类型的方法则需等待，也就是同步。
     *
     * @param args
     */
    public static void main(String[] args) {
        MyObject object = new MyObject();
        ThreadA_M a = new ThreadA_M(object);
        a.setName("A");
        ThreadB_M b = new ThreadB_M(object);
        b.setName("B");
        a.start();
        b.start();
    }
}
