public class Diff {
  // Differentiate synchronized static and synchronized instance methods with an example
  public synchronized void methodA() {
      for (int i = 0; i < 5; i++) {
          System.out.println(Thread.currentThread().getName());
      }
  }

  public synchronized void methodB() {
      for (int i = 0; i < 5; i++) {
          System.out.println(Thread.currentThread().getName());
      }
  }

  public static void main(String[] args) {
      // Creating an instance of SyncDifference
      Diff instance1 = new Diff();
      
      // Thread tA calls methodA on instance1
      Thread tA = new Thread() {
          public void run() {
              instance1.methodA();
          }
      };
      tA.start();

      // Thread tB calls methodB on instance1
      Thread tB = new Thread() {
          public void run() {
              instance1.methodB();
          }
      };
      tB.start();

      // Differentiate between method-level lock and class-level lock
      Diff instance2 = new Diff();
      Thread tC = new Thread() {
          public void run() {
              instance2.methodB();
          }
      };
      tC.start();

      Diff instance3 = new Diff();
      Thread tD = new Thread() {
          public void run() {
              instance3.methodB();
          }
      };
      tD.start();
  }
}
