package thread_1.第一章第10小节线程优先级;

/**
 * 优先级具有规则性。
 * 线程1优先执行完。因为它的优先级比线程2的优先级高。但不是总是线程1执行完。因为线程具有随机性。
 * 输出：
 * thread1 use time=181
 * thread1 use time=238
 * thread2 use time=287
 * thread1 use time=293
 * thread1 use time=309
 * thread1 use time=318
 * thread2 use time=279
 * thread2 use time=310
 * thread2 use time=349
 * thread2 use time=340
 */

import java.util.Random;

public class MyThread11021 extends Thread {
    public void run(){
        long beginTime=System.currentTimeMillis();
        long addResult = 0;
        for(int j=0;j<10;j++){
            for(int i=0;i<50000;i++){
                Random random = new Random();
                random.nextInt();
                addResult = addResult+1;
            }
        }
        long endTime=System.currentTimeMillis();
        System.out.println("thread1 use time="+(endTime - beginTime));
    }

    public static void main(String[] args) {
        for (int i=0;i<5;i++){
            MyThread11022 myThread11022= new MyThread11022();
            myThread11022.setPriority(1);
            myThread11022.start();
            MyThread11021 myThread11021=new MyThread11021();
            myThread11021.setPriority(10);
            myThread11021.start();

        }
    }
}
