public class YieldnJoin extends Thread {
    public void op() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + ": " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        YieldnJoin y = new YieldnJoin();

        Thread t = new Thread() {
            public void run() {
                y.op();
            }
        };
        t.setPriority(5);
        t.start();

        Thread t1 = new Thread() {
            public void run() {
                y.op();
            }
        };
        t1.setPriority(5);
        t1.setName("Yield");
        t1.start();


        Thread.yield();

        Thread t2 = new Thread() {
            public void run() {
                y.op();
            }
        };
        t2.setPriority(2);
        t2.start();
    }
}
