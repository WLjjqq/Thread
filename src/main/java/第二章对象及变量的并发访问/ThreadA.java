package 第二章对象及变量的并发访问;

public class ThreadA extends Thread {
    private HasSelfPrivateNum numRef;
    public ThreadA(HasSelfPrivateNum numRef){
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("a");
    }

    /**
     * 两个线程同时访问一个没有同步的方法addI.如果两个线程同时操作业务对象中的实例变量，则有可能会出现“非线程安全”问题。
     * 输出结果：
     * a set over!
     * b set over
     * b num=200
     * a num=200
     *
     * 解决方案：给addI()方法加上synchronized
     * 结论：两个线程访问同一个对象中的同步方法时一定是线程安全的。
     * 输出结果：
     * a set over!
     * a num=100
     * b set over
     * b num=200
     * @param args
     */
    public static void main(String[] args) {
        HasSelfPrivateNum numRef = new HasSelfPrivateNum();
        ThreadA threadA = new ThreadA(numRef);
        threadA.start();
        ThreadB threadB = new ThreadB(numRef);
        threadB.start();
    }
}


