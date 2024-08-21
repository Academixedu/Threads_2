public class Diff{
// Differentitae Synchronize static and Sunchronize with an Example 
  // Run it here by creating Thread Class Object
  // Diffrentiate Method Level Lock and Class Level Lock
  public synchronized void m1() {
    for (int i = 1; i <= 5; i++) {
        System.out.println("Static" + Thread.currentThread().getName());
    }
}

public static synchronized void m2() {
    for (int i = 1; i <= 5; i++) {
        System.out.println("Static " + Thread.currentThread().getName());
    }
}

public static void main(String[] args) {
    // Creating first instance
    Diff d = new Diff();
    Thread t1 = new Thread() {
        public void run() {
            d.m1(); 
        }
    };
    t1.start();

    Diff d1 = new Diff();
    Thread t2 = new Thread() {
        public void run() {
            d1.m1();
        }
    };
    t2.start();
    
    Thread t3 = new Thread() {
        public void run() {
            Diff.m2();
        }
    };
    t3.start();
  }
}
