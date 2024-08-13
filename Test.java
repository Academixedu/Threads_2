public class Test {
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

    producer.setPriority(Thread.MAX_PRIORITY);
    consumer.setPriority(Thread.MIN_PRIORITY);

    producer.start();
    consumer.start();
  }
}