public class Diff {

    public synchronized void m1() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Instance " + Thread.currentThread().getName());
        }
    }

    public static synchronized void m2() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Static " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        // Creating first instance
        Diff s = new Diff();
        Thread t1 = new Thread() {
            public void run() {
                s.m1(); 
            }
        };

      
        Diff s1 = new Diff();
        Thread t2 = new Thread() {
            public void run() {
                s1.m1();
            }
        };

        
        Thread t3 = new Thread() {
            public void run() {
                Diff.m2();
            }
        };

        Thread t4 = new Thread() {
            public void run() {
                Diff.m2(); 
            }
        };

     
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
