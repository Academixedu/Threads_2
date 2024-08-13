class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
            // Yield control to other threads
            Thread.yield();
        }
    }
}

public class YieldnJoin {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("Thread-1");
        MyThread t2 = new MyThread("Thread-2");
        MyThread t3 = new MyThread("Thread-3");

        t1.start();
        t2.start();
        t3.start();

        try {
            // Ensure t1 completes before proceeding
            t1.join();
            System.out.println(t1.getName() + " has finished.");

            // Ensure t2 completes before proceeding
            t2.join();
            System.out.println(t2.getName() + " has finished.");

            // Ensure t3 completes before proceeding
            t3.join();
            System.out.println(t3.getName() + " has finished.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads have finished execution.");
    }
}

