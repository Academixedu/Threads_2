public class Diff {
  // Class-level lock
  private static final Object classLock = new Object();

  // Instance-level lock
  private final Object instanceLock = new Object();

  // Static synchronized method (class-level lock)
  public static synchronized void staticSynchronizedMethod() {
      System.out.println("Static synchronized method");
      try {
          Thread.sleep(1000);
      } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
      }
      System.out.println("Static synchronized method finished");
  }

  // Synchronized method with instance-level lock
  public synchronized void instanceSynchronizedMethod() {
      System.out.println("Instance synchronized method");
      try {
          Thread.sleep(1000);
      } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
      }
      System.out.println("Instance synchronized method finished");
  }

  // Synchronized block with class-level lock
  public void classLevelLock() {
      synchronized (classLock) {
          System.out.println("Class-level lock");
          try {
              Thread.sleep(1000);
          } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
          }
          System.out.println("Class-level lock finished");
      }
  }

  // Synchronized block with instance-level lock
  public void instanceLevelLock() {
      synchronized (instanceLock) {
          System.out.println("Instance-level lock");
          try {
              Thread.sleep(1000);
          } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
          }
          System.out.println("Instance-level lock finished");
      }
  }

  public static void main(String[] args) {
      Diff diff1 = new Diff();
      Diff diff2 = new Diff();

      // Test static synchronized method
      Thread thread1 = new Thread(Diff::staticSynchronizedMethod);
      Thread thread2 = new Thread(Diff::staticSynchronizedMethod);
      thread1.start();
      thread2.start();

      // Test instance synchronized method
      Thread thread3 = new Thread(() -> diff1.instanceSynchronizedMethod());
      Thread thread4 = new Thread(() -> diff2.instanceSynchronizedMethod());
      thread3.start();
      thread4.start();

      // Test class-level lock
      Thread thread5 = new Thread(() -> diff1.classLevelLock());
      Thread thread6 = new Thread(() -> diff2.classLevelLock());
      thread5.start();
      thread6.start();

      // Test instance-level lock
      Thread thread7 = new Thread(() -> diff1.instanceLevelLock());
      Thread thread8 = new Thread(() -> diff2.instanceLevelLock());
      thread7.start();
      thread8.start();
  }
}