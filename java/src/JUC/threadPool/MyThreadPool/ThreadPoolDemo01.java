package src.JUC.threadPool.MyThreadPool;

public class ThreadPoolDemo01 {

    public static void main(String[] args) {

        // 创建线程池对象,无参构造方法创建
        ThreadPool threadPool = new ThreadPool();  // 默认核心线程数量为 2
        // ThreadPool threadPool = new ThreadPool(5);

        // 提交任务
        for(int x = 0 ; x < 10 ; x++) {
            threadPool.submit( () -> System.out.println(Thread.currentThread().getName() + "---->>>处理了任务"));
        }

    }

}