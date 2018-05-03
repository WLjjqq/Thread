package thread_1.第一章第10小节线程优先级;

/**
 * 输出结果：
 * a = 973199671
 * b = 1085128998
 * 这个只是随机性的。主要是验证：优先级高的运行的快。
 */
public class MyThreadA extends Thread {
    private int count=0;
    public int getCount(){
        return count;
    }
    public void run(){
        while(true){
            count++;
        }
    }

    public static void main(String[] args) {
        MyThreadA myThreadA = new MyThreadA();
        myThreadA.setPriority(Thread.NORM_PRIORITY - 3);
        myThreadA.start();
        MyThreadB myThreadB = new MyThreadB();
        myThreadB.setPriority(Thread.NORM_PRIORITY + 3);
        myThreadB.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThreadA.stop();
        myThreadB.stop();
        System.out.println("a = " + myThreadA.getCount());
        System.out.println("b = " + myThreadB.getCount());

    }
}
