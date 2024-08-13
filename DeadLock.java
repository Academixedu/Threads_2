public class DeadLock {

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public static void main(String[] args) {
        DeadLock deadlock = new DeadLock();
        deadlock.createDeadlock();
    }

    private void createDeadlock() {
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                synchronized (lock2) {
                    System.out.println("Thread 1: Locked both locks");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                synchronized (lock1) {
                    System.out.println("Thread 2: Locked both locks");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
