# Thread
一：使用Thread有两种方式。
1）：继承Thread类。
2）：实现Runnable 接口
3）：实例变量和线程安全的问题。
1：给方法或类加上锁。synchronized
2：currentThread()：可返回代码段正在被哪个线程调用的信息。
3：isAlive()：判断当前的线程是否处于活动状态
4：sleep():在毫秒内让当前“正在执行的线程”休眠。
5：getId():获取线程的唯一标识
