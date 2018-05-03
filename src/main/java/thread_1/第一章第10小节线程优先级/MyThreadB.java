package thread_1.第一章第10小节线程优先级;

public class MyThreadB extends Thread {
    private int count=0;
    public int getCount(){
        return count;
    }
    public void run(){
        while(true){
            count++;
        }
    }
}
