package thread_1;

/**
 *  知识点：this.currentThread().getName()。打印当前线程的名字
 *  1）：myThread.start();输出结果：
 *          构造方法打印main
 *          run方法打印Thread-0
 *   2）：myThread.run();输出结果
 *          构造方法打印main
 *          run方法打印main
 *     说明构造器是被main线程调用。 run()方法只是CurrentThread类的一个方法，是被Thread-0线程调用。
 */
public class CurrentThread extends Thread{
    public CurrentThread(){
        System.out.println("构造方法打印"+this.currentThread().getName());
    }

    @Override
    public void run() {
        super.run();
        System.out.println("run方法打印"+this.currentThread().getName());
    }

    public static void main(String[] args) {
        CurrentThread myThread=new CurrentThread();
        myThread.run();
    }
}
