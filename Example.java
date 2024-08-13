public class Example{
    // Preapare an Example for Inter Thread Communincation use wait() and Notify() Methods
    public synchronized void m1() {
        try{
            wait(1000);
        } catch (Exception e) {
        }
        for(int i=0;i<5;i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
    public synchronized void m2() {
        for(int i=0;i<5;i++) {
            System.out.println(Thread.currentThread().getName());
        }
        notify();
    }
        public static void main(String[] args) {
            Example e = new Example();
            Thread t = new Thread() {
                public void run() {
                    e.m1();
                }
            };
            t.setPriority(1);
            t.start();
            Thread t1 = new Thread() {
                public void run() {
                    e.m2();
                }
            };
            t1.setPriority(10);
            t1.start();
    
        }
    }
    
