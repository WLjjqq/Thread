package thread_1.第一章第10小节线程优先级;

public class MyThread11012 extends Thread {
    public void run(){
        System.out.println("MyThread2 run priority = "+this.getPriority());
    }
}
