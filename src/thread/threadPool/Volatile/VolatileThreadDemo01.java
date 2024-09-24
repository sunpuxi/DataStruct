package src.thread.threadPool.Volatile;

public class VolatileThreadDemo01 {
    
    public static void main(String[] args) {

        // 创建VolatileThread线程对象
        VolatileThread volatileThread = new VolatileThread() ;
        volatileThread.start();

        // 在main线程中获取开启的线程中flag的值
        while(true) {
            System.out.println("main线程中获取开启的线程中flag的值为" + volatileThread.isFlag());
        }

        /**
         * 观察到的结果，先是 false 后变成 true
         *
         */
    }
}