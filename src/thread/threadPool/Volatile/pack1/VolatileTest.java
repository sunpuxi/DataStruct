package src.thread.threadPool.Volatile.pack1;


/**
 * 将 VolatileThread 的成员变量修改为 volatile 修饰之后
 */
public class VolatileTest extends Thread{
        boolean flag = false;
        int i = 0;

        public void run() {
            while (!flag) {
                i++;
            }
            System.out.println("stop" + i);
        }

        public static void main(String[] args) throws Exception {
            VolatileTest vt = new VolatileTest();
            vt.start();
            Thread.sleep(10);
            vt.flag = true;
        }
    }