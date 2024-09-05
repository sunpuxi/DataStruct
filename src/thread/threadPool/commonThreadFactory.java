package src.thread.threadPool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 通用线程工厂
 */
public class commonThreadFactory implements ThreadFactory {

    private String threadPrefix;

    private AtomicInteger threadIdx = new AtomicInteger(0);

    /**
     * Constructs a new {@code Thread}.  Implementations may also initialize
     * priority, name, daemon status, {@code ThreadGroup}, etc.
     *
     * @param r a runnable to be executed by new thread instance
     * @return constructed thread, or {@code null} if the request to
     * create a thread is rejected
     */
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName(threadPrefix + "--sunpx--"+threadIdx.getAndIncrement());
        return thread;
    }

    public commonThreadFactory(String threadPrefix){
        this.threadPrefix = threadPrefix;
    }
}
