public class Diff{
    // Differentitae Synchronize static and Sunchronize with an Example 
    public synchronized void m1(){
    
      for(int i=0;i<5;i++){
          System.out.println(Thread.currentThread().getName());
      }
    }
    
    public static synchronized void m2(){
    
      for(int i=0;i<5;i++){
          System.out.println(Thread.currentThread().getName());
      }
    }
    
    public static void main(String[] args) {
      // Run it here by creating Thread Class Object
      Diff d = new Diff();
      Thread t= new Thread(){
        public void run(){
          Diff.m2();
        }
      };
      t.start();
      Thread t1 = new Thread(){
        public void run(){
          Diff.m2();
        }
      };
      t1.start();
      // Diffrentiate Method Level Lock and Class Level Lock
      Diff d1 = new Diff();
      Thread t2 = new Thread(){
        public void run(){
          d1.m2();
        }
      };
      t2.start();
      Diff d2 = new Diff();
      Thread t3 = new Thread(){
        public void run(){
          d2.m2();
        }
      };
      t3.start();
    }
  }