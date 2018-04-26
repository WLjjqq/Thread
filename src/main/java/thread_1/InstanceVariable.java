package thread_1;

/**
 * 实例变量和线程的安全问题
 * 实例变量不共享。数据是安全的。
 * 输出的结果。
 * 由A计算，count=4
 * 由C计算，count=4
 * 由B计算，count=4
 * 由C计算，count=3
 * 由C计算，count=2
 * 由C计算，count=1
 * 由C计算，count=0
 * 由A计算，count=3
 * 由A计算，count=2
 * 由A计算，count=1
 * 由A计算，count=0
 * 由B计算，count=3
 * 由B计算，count=2
 * 由B计算，count=1
 * 由B计算，count=0
 */
public class InstanceVariable extends Thread{
    private int count=5;

    public InstanceVariable(String name) {
        super();
        this.setName(name);// 设置线程的名字
    }

    @Override
    public void run() {
        super.run();
        while (count>0){
            count--;
            System.out.println("由"+this.currentThread().getName()+"计算，count="+count);
        }
    }

    public static void main(String[] args) {
        InstanceVariable a = new InstanceVariable("A");
        InstanceVariable b = new InstanceVariable("B");
        InstanceVariable c = new InstanceVariable("C");
        a.start();
        b.start();
        c.start();
    }
}
