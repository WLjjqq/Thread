package thread_1;

/**
 * 使用线程，第一种方式
 * 知识点：由下面的输出结果可以看出。线程的执行顺序和代码的先后没有关系。是随机生成的。
 */
public class MyThread extends Thread{
    //重写run()方法
    public void run(){
        super.run();
        System.out.println("MyThread");
    }

    //使用线程
    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        myThread.start();
        System.out.println("运行结束！！！");
    }

   /* 输出的结果：
    运行结束！！！
    MyThread*/


}
