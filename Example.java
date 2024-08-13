public class Example {

    private boolean isProduced = false;

    public synchronized void produce() {
        while (isProduced) {
            try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        System.out.println("Produced an item");
        isProduced = true;
        notify();
    }

    public synchronized void consume() {
        while (!isProduced) {
            try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        System.out.println("Consumed the item");
        isProduced = false;
        notify();
    }

    public static void main(String[] args) {
        Example example = new Example();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) example.produce();
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) example.consume();
        }).start();
    }
}
