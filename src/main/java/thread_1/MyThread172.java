package thread_1;

/**
 * interrupt：n.中断
 * 需要熟记 interrupt()方法是停止线程的。
 * this.interrupted():测试当前线程是否已经中断。  执行后具有将状态标志置清除为false的功能。
 *      public static boolean interrupted()
 * this.isInterrupted();测试线程是否已经中断。  执行后不清除状态标志。
 *      public boolean isInterrupted()
 */
public class MyThread172 extends Thread{
    public void run(){
        super.run();
        for(int i=0;i<500000;i++){
            System.out.println("i=" +(i+1));
        }
    }

    public static void main(String[] args) {

        /*try {
            MyThread172 myThread172 = new MyThread172();
            myThread172.start();
            Thread.sleep(10000);
            myThread172.interrupt();
            System.out.println("是否停止1？= "+myThread172.interrupted());
            System.out.println("是否停止2？= "+myThread172.interrupted());
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end");*/
        /**
         * i=500000
         * 是否停止1？= false
         * 是否停止2？= false
         * end
         */

        /*Thread.currentThread().interrupt();
        System.out.println("是否停止1？= "+Thread.interrupted());
        System.out.println("是否停止2？= "+Thread.interrupted());
        System.out.println("end");*/
        /**输出结果：
         *  i=50000
         *  是否停止1？= true
         *  是否停止2？= false
         *  end
         *  为什么第二次是false呢？ 因为这个方法可以清除线程的中断状态。换句话说，如果连续两次调用该方法，第二次调用将返回false。
         */
        /*try {
            MyThread172 myThread172 = new MyThread172();
            myThread172.start();
            Thread.sleep(1000);
            myThread172.interrupt();
            System.out.println("是否停止1？= "+myThread172.isInterrupted());
            System.out.println("是否停止2？= "+myThread172.isInterrupted());
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end");*/
        /**
         * 输出结果
         * i=63801
         * 是否停止1？= true
         * 是否停止2？= true
         * end
         * i=63802
         */

        MyThread172 myThread172=new MyThread172();
        String name =myThread172.currentThread().getName();
        System.out.println("myThread172线程的名字： "+name);
        System.out.println("Thread线程的名字："+Thread.currentThread().getName());
        /**
         * 名字输出的一样。都是main 。但是Thread没有isInterrupted()方法。myThread172没有interrupted()方法。
         */
    }
}

