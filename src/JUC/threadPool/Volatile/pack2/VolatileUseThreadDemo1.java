package src.JUC.threadPool.Volatile.pack2;

import java.util.concurrent.TimeUnit;

/**
 * 测试案例二
 * 在这个案例中，由于情况过于简单，无论变量有没有被 volatile 修饰，最终的结果都是相同的。
 * 此场景下 volatile 的作用。保证其修饰的变量的可见性，可以被其他线程立刻观察到。
 */
public class VolatileUseThreadDemo1 {

    public static class VolatileUseThread implements Runnable {

        // 定义标志变量
        private volatile boolean shutdown = false ;

        @Override
        public void run() {

            while(!shutdown) {
                System.out.println("lueluelue....");
            }

        }

        // 关闭线程
        public void shutdown() {
            this.shutdown = true ;
        }
    }

    public static void main(String[] args) {
        // 创建线程
        VolatileUseThread thread  = new VolatileUseThread();

        // 创建线程任务类对象
        Thread thread1  = new Thread(thread);

        // 启动执行任务
        thread1.start();

        // 主线程休眠
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // 关闭线程
        thread.shutdown();
    }
}
