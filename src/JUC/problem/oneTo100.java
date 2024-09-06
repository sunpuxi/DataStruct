package src.JUC.problem;

/**
 * 两个线程轮流打印 1到100
 * 创建两个线程，一个标志位判断是否轮到某个线程进行打印
 * 当某个先成抢到锁的时候，根据标志位进行信息打印，打印完毕之后，唤醒其他线程
 */
public class oneTo100 {
    static int number = 1;
    static boolean isThreadOne = true;

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            while (number<=100) {
                synchronized (oneTo100.class){
                    if (isThreadOne){
                        System.out.println(Thread.currentThread().getName()+":"+number++);
                        isThreadOne = false;
                        oneTo100.class.notifyAll();
                    }else{
                        try {
                            oneTo100.class.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        },"t1");

        Thread t2 = new Thread(()->{
            while (number<=100) {
                synchronized (oneTo100.class){
                    if (!isThreadOne){
                        System.out.println(Thread.currentThread().getName()+":"+number++);
                        isThreadOne = true;
                        oneTo100.class.notifyAll();
                    }else{
                        try {
                            oneTo100.class.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        },"t2");

        t1.start();
        t2.start();
    }
}
