package src.JUC.threadPool.Volatile.pack2;


/**
 * 案例二测试
 */
public class VolatileUseThread implements Runnable {

    // 定义标志变量
    private  boolean shutdown = false ;

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