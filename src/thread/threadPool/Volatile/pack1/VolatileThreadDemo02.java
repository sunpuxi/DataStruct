package src.thread.threadPool.Volatile.pack1;

import java.util.concurrent.TimeUnit;

public class VolatileThreadDemo02 {

    public static void main(String[] args) throws InterruptedException {

        // 创建VolatileThread线程对象
        VolatileThread volatileThread = new VolatileThread() ;
        volatileThread.start();

        // main方法
        while(true) {

            if(volatileThread.isFlag()) {
                System.out.println("执行了======");
            }

            // 让线程休眠100毫秒
            // 在某一时刻读取到volatileThread写会主内存的值
            TimeUnit.MILLISECONDS.sleep(100);
        }

    }
}