public class Example {
    private boolean flag = false;

    public synchronized void produce() throws InterruptedException {
        while (flag) {
            wait();
        }
        System.out.println("Produced item");
        flag = true;
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while (!flag) {
            wait();
        }
        System.out.println("Consumed item");
        flag = false;
        notify();
    }

    public static void main(String[] args) {
        Example example = new Example();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    example.produce();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    example.consume();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}