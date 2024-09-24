package src.thread.threadPool.Volatile.pack1;


/**
 * 工作原理说明
 * 对上述代码加锁完毕以后，某一个线程支持该程序的过程如下：
 * a.线程获得锁
 * b.清空工作内存
 * c.从主内存拷贝共享变量最新的值到工作内存成为副本
 * d.执行代码
 * e.将修改后的副本的值刷新回主内存中
 * f.线程释放锁
 */
public class VolatileThreadDemo03 {

    public static void main(String[] args) throws InterruptedException {

        // 创建VolatileThread线程对象
        VolatileThread volatileThread = new VolatileThread();
        // 底层调用 run 方法
        // start 只能调用一次
        volatileThread.start();
        // main方法
        while (true) {
            // 加锁进行问题处理
            synchronized (volatileThread) {
                if (volatileThread.isFlag()) {
                    System.out.println("执行了======");
                }
            }

        }
        // 结果分析，当调用 start 方法之后，输出 flag = true
        // 当主线程抢到锁之后，开始清空自己的工作内存。
        // 后面输出： 执行了=====
    }
}