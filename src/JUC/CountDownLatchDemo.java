package src.JUC;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor ex = new ThreadPoolExecutor(
                1,
                1,
                200,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>()
        );
        List<String> list = new ArrayList<>();
        long start = System.currentTimeMillis();
        CountDownLatch count = new CountDownLatch(100000);
        for (int i = 0; i < 100000; i++) {
            ex.execute(()->{
                try {
                    list.add("1");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    count.countDown();
                }
            });
        }
        count.await();
        long end = System.currentTimeMillis();
        System.out.println(list.size()+"用时"+(end-start));
    }
}
