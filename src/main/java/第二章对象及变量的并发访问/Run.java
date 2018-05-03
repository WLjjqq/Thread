package 第二章对象及变量的并发访问;

/**
 * 当多个线程访问多个对象。也不是同步的。
 * 输出结果：
 * a set over!
 * b set over
 * b num=200
 * a num=100
 */
public class Run {
    public static void main(String[] args) {
        HasSelfPrivateNum numRef = new HasSelfPrivateNum();
        HasSelfPrivateNum numRef2 = new HasSelfPrivateNum();
        ThreadA threadA = new ThreadA(numRef);
        threadA.start();
        ThreadB threadB = new ThreadB(numRef2);
        threadB.start();
    }
}
