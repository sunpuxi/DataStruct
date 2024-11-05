package src.JUC.threadPool.Volatile.pack1;

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
         * 1、VolatileThread 的 flag 没有被 volatile 修饰时候。
         * 观察到的结果，先是 false 后变成 true
         * 2、当VolatileThread 的 flag 被 volatile 修饰时候。
         * 观察到的结果就全是 false 了。
         */
    }
}