public class Test{
// Create Thread Here and Test it Here of Logic Written in Example File
  // Apply Thread Class Priority() Methodpublic class Test {
    public static void main(String[] args) {
      Example d = new Example();
      Thread t = new Thread(() -> {
          d.deposit(11000.0);
      });
      t.setPriority(Thread.MIN_PRIORITY);
      t.start();

      Thread t1 = new Thread(() -> {
          d.withdrawl(500.0);
      });
      t1.setPriority(Thread.MAX_PRIORITY);
      t1.start();
  }
}

  
  
  

