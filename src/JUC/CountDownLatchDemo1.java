package src.JUC;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo1 {

    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        long start = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            list.add("1");
        }
        long end = System.currentTimeMillis();
        System.out.println(list.size()+"用时"+(end-start));
    }
}
