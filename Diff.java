public class Diff{
// Differentitae Synchronize static and Sunchronize with an Example 
  // Run it here by creating Thread Class Object
  // Diffrentiate Method Level Lock and Class Level Lock
  public synchronized void a1(){
    for (int i=1; i<=8; i++){
      System.out.println("Static:1 " +" "+ Thread.currentThread().getName());
    }
  }
  public static synchronized void a2(){
    for(int i=1; i<=8; i++){
      System.out.println("STatic:2 "+ " " + Thread.currentThread().getName());
    }
  }
  public static void main(String[] args) {
    Diff d = new Diff();
    Thread t = new Thread(){
      public void run(){
        d.a1();
      }
    };t.start();
  
  Diff d1 = new Diff();
  Thread t1 = new Thread(){
    public void run(){
      d1.a2();
    }
  };t1.start();
}
}