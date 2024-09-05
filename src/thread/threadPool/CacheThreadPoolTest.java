package src.thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CacheThreadPoolTest
 * 创建一个可缓存的无界线程池，如果线程池长度超过处理需要，
 * 可灵活回收空线程，若无可回收，则新建线程。当线程池中的线程空闲时间超过60s，
 * 则会自动回收该线程，当任务超过线程池的线程数则创建新的线程，线程池的大小上限为 Integer.MAX_VALUE,可看作无限大。
 */
public class CacheThreadPoolTest {

    public static void main(String[] args) {
        commonThreadFactory commonThreadFactory = new commonThreadFactory("threadPoolTest");
        ExecutorService executorService = Executors.newCachedThreadPool(commonThreadFactory);
        for (int i = 0; i < 10; i++) {
            executorService.submit(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}
