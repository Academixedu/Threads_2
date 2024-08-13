public class Test{
  // Create Thread Here and Test it Here of Logic Written in Example File
  public static void main(String[] args) {
    Thread t = new Thread() {
      public void run() {
        for (int i = 0; i < 5; i++) {
          System.out.println("  THREAD-2");
        }
      } 
    };
    t.setPriority(10);
    t.start();
    Thread t1 = new Thread() {
      public void run() {
        for (int i = 0; i < 5; i++) {
          System.out.println("THREAD-1");
        }
      }
    };
    t1.setPriority(3);
    t1.start();
    }
  }
    // Apply Thread Class Priority() Method