package thread_1;

/**
 * 实例变量和线程的安全问题
 * 实例变量共享。数据不安全的。
 * 输出的结果。(这个结果是随机的。3出现了两次)。产生了“非线程安全”问题。
 *由A计算，count=3
 *由D计算，count=1
 *由C计算，count=2
 *由E计算，count=3
 *由B计算，count=0
 *知识点：在某些JVM中。i--的操作分3步
 *      1）：取得原有值。
 *      2）：计算i-1。
 *      3）：对i进行赋值
 *
 *  解决方案。给这个run()方法添加上synchronized
 *  就是给run()方法加上锁。以排队的方式进行处理。
 */
public class InstanceVariable2 extends Thread{
    private int count=5;
    @Override
    synchronized public void run() {
        super.run();
            count--;
            System.out.println("由"+this.currentThread().getName()+"计算，count="+count);
    }

    public static void main(String[] args) {
        InstanceVariable2 thread = new InstanceVariable2();
        Thread a = new Thread(thread,"A");
        Thread b = new Thread(thread,"B");
        Thread c = new Thread(thread,"C");
        Thread d = new Thread(thread,"D");
        Thread e = new Thread(thread,"E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
