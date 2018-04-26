package thread_1;

/**
 * getId():获取线程的唯一标识
 */
public class MyThread_getId extends Thread{
    public static void main(String[] args) {
        MyThread_getId myThread_getId = new MyThread_getId();
        System.out.println(myThread_getId.getName()+"  "+myThread_getId.getId());
    }
}
