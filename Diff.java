public class Diff {

  public synchronized void methodLevelSync() {
    for (int i = 0; i < 5; i++) {
      System.out.println(Thread.currentThread().getName() + " - Method Level Sync: " + i);
    }
  }

  public static synchronized void classLevelSync() {
    for (int i = 0; i < 5; i++) {
      System.out.println(Thread.currentThread().getName() + " - Class Level Sync: " + i);
    }
  }

  public static void main(String[] args) {
    Diff diffInstance = new Diff();

    Thread t1 = new Thread(() -> diffInstance.methodLevelSync(), "Thread 1");
    Thread t2 = new Thread(() -> diffInstance.methodLevelSync(), "Thread 2");

    Thread t3 = new Thread(() -> Diff.classLevelSync(), "Thread 3");
    Thread t4 = new Thread(() -> Diff.classLevelSync(), "Thread 4");

    t1.start();
    t2.start();
    t3.start();
    t4.start();
  }
}