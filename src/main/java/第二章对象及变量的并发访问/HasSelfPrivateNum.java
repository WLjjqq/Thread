package 第二章对象及变量的并发访问;

public class HasSelfPrivateNum {
    private int num=0;
    synchronized public void addI(String username){
        try{
            if(username.equals("a")){
                num = 100;
                System.out.println("a set over!");
                Thread.sleep(20000);
            }else {
                num = 200;
                System.out.println("b set over");
            }
            System.out.println(username +" num=" +num);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
