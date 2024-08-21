public class YieldnJoin extends Thread {
    public void op() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ": " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        YieldnJoin y = new YieldnJoin();

        // Thread 1
        Thread t = new Thread() {
            public void run() {
                y.op();
            }
        };
        t.setPriority(5);
        t.start();

        // Thread 2
        Thread t1 = new Thread() {
            public void run() {
                y.op();
            }
        };
        t1.setPriority(5);
        t1.setName("Yield");
        t1.start();

        // Yielding the current thread
        Thread.yield();

        // Thread 3
        Thread t2 = new Thread() {
            public void run() {
                y.op();
            }
        };
        t2.setPriority(2);
        t2.start();
    }
}
