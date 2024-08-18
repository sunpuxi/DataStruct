package src.JUC;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            Thread.sleep(3000);
            System.out.println("休眠结束");
            return 100;
        });


        Thread t = new Thread(futureTask,"T1");
        t.start();

        //获取 futureTask 的返回值，阻塞线程直至 futureTask 线程运行结束
        System.out.println("futureTask 的返回值为："+futureTask.get());
    }
}
