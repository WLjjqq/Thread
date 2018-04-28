package thread_1;

/**
 * yield():放弃当前的CPU资源。将它让给其他的任务去占用CPU执行时间。但是放弃的时间不确定，有可能刚刚放弃，又获得CPU时间片了。
 * 不使用 yield()方法的话，相差6秒，使用了yield()方法的话，相差了50秒
 */
public class MyThread19 extends Thread {
    public void run(){
        long beginTime=System.currentTimeMillis();
        int count=0;
        for(int i=0;i<500000;i++){
            Thread.yield();
            count=count+(i+1);
        }
        long endTime=System.currentTimeMillis();
        System.out.println("相差的时间 "+(endTime - beginTime)+"毫秒");
    }

    public static void main(String[] args) {
        MyThread19 thread19 = new MyThread19();
        thread19.start();
    }
}
