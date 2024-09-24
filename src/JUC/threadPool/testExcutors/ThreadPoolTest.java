package src.JUC.threadPool.testExcutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

    public static void main(String[] args) {

        // 可以认为没有上限（int 的最大值）
        ExecutorService pool1 = Executors.newCachedThreadPool();
        MyTask task = new MyTask();

        // 开启任务
        pool1.submit(task);
        pool1.submit(task);
        pool1.submit(task);
    }
}
