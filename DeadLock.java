public class DeadLock {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        deadLock.createDeadlock();
    }

    public void createDeadlock() {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                synchronized (lock1) {
                    System.out.println("Thread 1: Holding lock 1...");

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                    System.out.println("Thread 1: Waiting for lock 2...");

                    synchronized (lock2) {
                        System.out.println("Thread 1: Holding lock 1 and lock 2...");
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                synchronized (lock2) {
                    System.out.println("Thread 2: Holding lock 2...");

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                    System.out.println("Thread 2: Waiting for lock 1...");

                    synchronized (lock1) {
                        System.out.println("Thread 2: Holding lock 1 and lock 2...");
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}