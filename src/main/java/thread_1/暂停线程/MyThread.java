package thread_1.暂停线程;

/**
 * suspend()暂停线程。
 * resume() 恢复线程
 * 这两个线程已经弃用了。因为会产生数据不同步问题。
 */
public class MyThread extends Thread {
    private long i=0;
    public long getI(){
        return i;
    }
    public void setI(long i){
        this.i=i;
    }
    public void run(){
        while(true){
            i++;
        }
    }

    public static void main(String[] args) {
        try {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(5000);
        //A段
        myThread.suspend();
        System.out.println("A= "+System.currentTimeMillis()+"i="+myThread.getI());
        Thread.sleep(5000);
            System.out.println("A = "+System.currentTimeMillis()+"i="+myThread.getI());
            //B段
            myThread.resume();
            Thread.sleep(5000);
            //C段
            myThread.suspend();
            System.out.println("B = " + System.currentTimeMillis() + "i = " + myThread.getI());
            Thread.sleep(5000);
            System.out.println("B = "+System.currentTimeMillis()+"i ="+myThread.getI());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
