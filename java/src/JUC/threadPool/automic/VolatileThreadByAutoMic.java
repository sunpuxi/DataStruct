package src.JUC.threadPool.automic;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * AutoMic 相关的原子类的使用方式
 */
public class VolatileThreadByAutoMic implements Runnable{

    // 初始化一个 int 类型的原子变量
    private AtomicInteger atomicInteger = new AtomicInteger();


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            // 先加在获取值
            int x = atomicInteger.incrementAndGet();
            System.out.println("count >>>> " + x);
        }
    }
}
