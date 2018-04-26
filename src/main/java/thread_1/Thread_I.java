package thread_1;

/**
 * i--的问题
 * 输出结果：
 * i=5线程名称Thread-1
 * i=4线程名称Thread-3
 * i=3线程名称Thread-4
 * i=2线程名称Thread-2
 * 知识点：println()是线程安全的。但是i--的操作却是在进入println()之前发生的。所以应该也加上锁：synchronized
 */
public class Thread_I extends Thread{
    private int i=5;
  synchronized public void run(){
        System.out.println("i= "+(i--)+" 线程名称 "+this.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread_I thread_i=new Thread_I();
        Thread a = new Thread(thread_i);
        Thread b = new Thread(thread_i);
        Thread c = new Thread(thread_i);
        Thread d = new Thread(thread_i);
        Thread e = new Thread(thread_i);
        a.start();
        b.start();
        c.start();
        d.start();
    }
}
