public class Diff {
  private static int counter = 0;
  public synchronized void instanceMethod() {
      for (int i = 0; i < 5; i++) {
          System.out.println("Instance Method - Count: " + (++counter) + " - " + Thread.currentThread().getName());
          try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
      }
  }
  public static synchronized void staticMethod() {
      for (int i = 0; i < 5; i++) {
          System.out.println("Static Method - Count: " + (++counter) + " - " + Thread.currentThread().getName());
          try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
      }
    }
  public static void main(String[] args) {
      Diff obj1 = new Diff();
      Diff obj2 = new Diff();
      new Thread(() -> obj1.instanceMethod()).start();
      new Thread(() -> obj2.instanceMethod()).start();
      new Thread(Diff::staticMethod).start();
      new Thread(Diff::staticMethod).start();
  }
}
