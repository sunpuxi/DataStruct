package src.JUC.problem;

/**
 * 让线程 A 执行完，轮到 B 执行
 * 知识点：join 方法是被 synchronized 修饰过的，并且内部的逻辑是只有当前的线程死亡后（或者被打断之后）才会释放锁
 */
public class inTurn {
   static class PrintThread extends Thread{

        PrintThread(String name){
            super(name);
        }

        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println(getName()+"  :  "+i+"...");
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {

        // 创建三个线程
        PrintThread t1 = new PrintThread("t1");
        PrintThread t2 = new PrintThread("t2");
        PrintThread t3 = new PrintThread("t3");

        // 轮流打印
        t1.run();
        t1.join();

        t2.run();
        t2.join();

        t3.run();
        t3.join();
    }
}
