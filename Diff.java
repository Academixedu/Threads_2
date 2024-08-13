public class Diff {

  
  public synchronized void methodLevelLock() {
      System.out.println(Thread.currentThread().getName() + " in methodLevelLock");
      try { Thread.sleep(1000); } catch (InterruptedException e) {}
  }


  public static synchronized void classLevelLock() {
      System.out.println(Thread.currentThread().getName() + " in classLevelLock");
      try { Thread.sleep(1000); } catch (InterruptedException e) {}
  }

  public static void main(String[] args) {
      Diff diff1 = new Diff();
      Diff diff2 = new Diff();

      new Thread(() -> diff1.methodLevelLock(), "Thread 1").start();
      new Thread(() -> diff2.methodLevelLock(), "Thread 2").start();

      new Thread(Diff::classLevelLock, "Thread 3").start();
      new Thread(Diff::classLevelLock, "Thread 4").start();
  }
}
