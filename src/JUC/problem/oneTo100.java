package src.JUC.problem;

/**
 * 两个线程轮流打印 1到100
 * 创建两个线程，一个标志位判断是否轮到某个线程进行打印
 */
public class oneTo100 {

    private static int number = 1;
    private static final Object lock = new Object();
    private static  boolean isTurnOfThread1 = true;

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            while(number <= 100){
                synchronized (lock){
                    if (isTurnOfThread1){
                        System.out.println(Thread.currentThread().getName()+":"+number++);
                        isTurnOfThread1 = false;
                        lock.notifyAll();
                    }else{
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        },"Thread1");

        Thread t2 = new Thread(()->{
            while(number <= 100){
                synchronized (lock){
                    if (!isTurnOfThread1){
                        System.out.println(Thread.currentThread().getName()+":"+number++);
                        isTurnOfThread1 = true;
                        lock.notifyAll();
                    }else{
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        },"Thread2");

        t1.start();
        t2.start();
    }
}
