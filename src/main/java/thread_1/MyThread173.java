package thread_1;
/**
 * 用break;虽然能停止线程，但是还是会执行for循环后面的值。
 * 用异常来停止线程。
 *如果检查出这个线程是停止的状态（this.interrupted() 为true）
 */
public class MyThread173 extends Thread {
    public void run() {
        try {
            for (int i = 0; i < 500000; i++) {
                if (this.interrupted()) {
                    System.out.println("已经是停止状态了，我要退出了");
                    throw new InterruptedException();
                }
                System.out.println("i= " + (i + 1));
            }
            System.out.println("我在for的后面");
        }catch (InterruptedException e){
            System.out.println("进入MyThread173类中的catch了");
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        try {
            MyThread173 thread173 = new MyThread173();
            thread173.start();
            Thread.sleep(2000);
            thread173.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end");
    }
}

    /**
     * 输出结果：
     * i= 450828
     * end
     * 已经是停止状态了，我要退出了
     * 进入MyThread173类中的catch了
     * java.lang.InterruptedException
     * 	at thread_1.MyThread173.run(MyThread173.java:13)
     */
