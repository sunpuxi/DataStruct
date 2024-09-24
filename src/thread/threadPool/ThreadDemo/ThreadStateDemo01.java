package src.thread.threadPool.ThreadDemo;

public class ThreadStateDemo01 {

    public static void main(String[] args) throws InterruptedException {

        //定义一个内部线程
        Thread thread = new Thread(() -> {
            System.out.println("2.执行thread.start()之后，线程的状态：" + Thread.currentThread().getState());
            try {
                //休眠100毫秒
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("4.执行Thread.sleep(long)完成之后，线程的状态：" + Thread.currentThread().getState());
        });

        //获取start()之前的状态
        System.out.println("1.通过new初始化一个线程，但是还没有start()之前，线程的状态：" + thread.getState());

        //启动线程
        thread.start();

        //休眠50毫秒
        Thread.sleep(50);

        //因为thread1需要休眠100毫秒，所以在第50毫秒，thread处于sleep状态
        //用main线程来获取thread1线程的状态，因为thread1线程睡眠时间较长
        //所以当main线程执行的时候，thread1线程还没有睡醒，还处于计时等待状态
        System.out.println("3.执行Thread.sleep(long)时，线程的状态：" + thread.getState());

        //thread1和main线程主动休眠150毫秒，所以在第150毫秒,thread早已执行完毕
        Thread.sleep(100);

        System.out.println("5.线程执行完毕之后，线程的状态：" + thread.getState() + "\n");

    }

}