public class Diff{
// Differentitae Synchronize static and Sunchronize with an Example 
  // Run it here by creating Thread Class Object
  // Diffrentiate Method Level Lock and Class Level Lock
  public synchronized void method1() {
    for (int i = 0; i < 5; i++) {
      System.out.println(Thread.currentThread().getName() + " " + i);
    }
  }

  public synchronized void method2() {
    for(int i = 0; i < 5; i++) {
      System.out.println(Thread.currentThread().getName() + " " + i);
    }

  }

  public static void main(String[] args) {
      Diff d = new Diff();

      Thread t1 = new Thread(() -> d.method1(), "T1");
      Thread t2 = new Thread(() -> d.method2(), "T2");
      t1.start();
      t2.start();
    
  }
}
