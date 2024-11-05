package src.JUC.StaticMethod;

public class Test1 {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                System.out.println("t1 is running");
                super.run();
            }
        };

        System.out.println(t1.getState());
        t1.start();
        //t1.start();
        System.out.println(t1.getState());
    }
}
