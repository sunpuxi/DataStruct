package src.JUC.threadPool.Volatile.pack1;

public class VolatileThread extends Thread {

    // 定义成员变量
    private volatile boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    @Override
    public void run() {
        // 线程休眠1秒
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 将flag的值更改为true
        this.flag = true;
        System.out.println("flag=" + flag);
    }
}
