public class Diff{
// Differentitae Synchronize static and Sunchronize with an Example 
  // Run it here by creating Thread Class Object
  // Diffrentiate Method Level Lock and Class Level Lock
  public synchronized  void m1()
  {
    for(int i=0; i<5;i++)
    {
      System.out.println(Thread.currentThread().getName());
    }

  }

  public static synchronized  void m2()
  {
    for(int i=0; i<5;i++)
    {
      System.out.println(Thread.currentThread().getName());
    }

  }

  public static void main(String[] args) {
    Diff d = new Diff();
    Thread t = new Thread()
    {
      public void run(){
        d.m1();
      }
    };t.start();

    Diff d2 = new Diff();
    Thread t2 = new Thread(){
      public void run(){
        d2.m2();
      }
    };
    t2.start();
  }
}

