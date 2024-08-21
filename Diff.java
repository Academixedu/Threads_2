
// Differentitae Synchronize static and Sunchronize with an Example 
  // Run it here by creating Thread Class Object
  // Diffrentiate Method Level Lock and Class Level Lock
  public class Diff {
    public  synchronized void m1(){
        for(int i=1;i<=5;i++){
            System.out.println("Static"+Thread.currentThread().getName());
        }
    }
    public static synchronized void m2(){
        for(int i=1;i<=5;i++){
            System.out.println("Static"+Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) {
    Diff s =new Diff();
    Thread t=new Thread(){
        public void run(){
           s.m1();
           
        }
    }; 
    t.start();
    Diff s1 =new Diff();
    Thread t1=new Thread(){
        public void run(){
           s1.m1();
        }
    }; 
    t1.start();
    }
}

