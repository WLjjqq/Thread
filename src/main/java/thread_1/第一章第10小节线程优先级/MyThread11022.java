package thread_1.第一章第10小节线程优先级;

import java.util.Random;

public class MyThread11022 extends Thread {
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
        System.out.println("thread2 use time="+(endTime - beginTime));
    }
}
