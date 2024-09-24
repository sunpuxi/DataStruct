package src.thread.threadPool.testExcutors;

public class getRuntime {

    public static void main(String[] args) {

        // 向 JVM 返回可用的处理器的数目
        int count = Runtime.getRuntime().availableProcessors();
        System.out.println(count);
    }
}
