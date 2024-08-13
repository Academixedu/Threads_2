public class YieldnJoin {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Thread 1 running");
                Thread.yield(); // Suggests giving up CPU time for other threads
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                thread1.join(); // Wait for thread1 to finish
                System.out.println("Thread 2 running after Thread 1 finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
    }
}
