 public class Test{
// Create Thread Here and Test it Here of Logic Written in Example File
  // Apply Thread Class Priority() Method
public class Test{
// Create Thread Here and Test it Here of Logic Written in Example File
  // Apply Thread Class Priority() Method
public class Test {

  public static void main(String[] args) {
      Example example = new Example();

      // Creating producer thread with high priority
      Thread producer = new Thread(() -> {
          for (int i = 0; i < 5; i++) example.produce();
      });
      producer.setName("Producer");
      producer.setPriority(Thread.MAX_PRIORITY);

      // Creating consumer thread with low priority
      Thread consumer = new Thread(() -> {
          for (int i = 0; i < 5; i++) example.consume();
      });
      consumer.setName("Consumer");
      consumer.setPriority(Thread.MIN_PRIORITY);

      // Start the threads
      producer.start();
      consumer.start();
  }
}
