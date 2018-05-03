package 第二章对象及变量的并发访问;

public class ThreadB_M extends Thread {
    private MyObject myObject;
    public ThreadB_M(MyObject object){
        super();
        this.myObject=object;
    }

    @Override
    public void run() {
        super.run();
        myObject.methodB();
    }
}
