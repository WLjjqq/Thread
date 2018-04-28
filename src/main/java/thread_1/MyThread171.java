package thread_1;

/**
 * interrupt()停止线程
 *
 */
public class MyThread171 extends Thread {
    public void run(){
        super.run();
        for(int i=0;i<50000;i++){
            System.out.println("i=" +(i+1));
        }
    }

    public static void main(String[] args) {
        try{
            MyThread171 myThread171 = new MyThread171();
            myThread171.start();
            Thread.sleep(2000);
            myThread171.interrupt();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
/**
 *输出的结果：
 * i=1
 * ....
 * i=50000
 * 调用interrupt()方法并没有停止线程。
 * */