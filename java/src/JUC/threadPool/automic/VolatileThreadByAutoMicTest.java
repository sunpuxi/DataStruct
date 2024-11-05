package src.JUC.threadPool.automic;


/**
 * 测试
 */
public class VolatileThreadByAutoMicTest {

    public static void main(String[] args) {

        // 创建线程
        VolatileThreadByAutoMic t = new VolatileThreadByAutoMic();

        // 启动任务
        for (int i = 0; i < 100; i++) {
            new Thread(t).run();
        }

    }
}
