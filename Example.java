public class Example {
    private static final Object lock = new Object();
    private static boolean isReady = false;

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Producer: Preparing data...");
                isReady = true;
                lock.notify();
            }
        });
        Thread consumer = new Thread(() -> {
            synchronized (lock) {
                while (!isReady) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Consumer: Data received.");
            }
        });
        consumer.start();
        producer.start();
    }
}
