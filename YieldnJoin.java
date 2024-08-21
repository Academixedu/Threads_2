public class YieldnJoin{
// Write Your Code Here
    public void op() {
        for(int i=0;i<10;i++) {
            System.out.println(i+":"+Thread.currentThread().getName());
        }
    }
        public static void main(String[] args) {
        Yield y=new Yield();
        Thread t=new Thread() {
            public void run() {
                y.op();
            }
        };
        
        t.setPriority(5);
        t.start();
        
        Thread t1=new Thread() {
            public void run() {
                y.op();
            }
        };t1.start();
        t1.setPriority(3);
        t1.setName("Yield");
        Thread.yield();
        
        Thread t2=new Thread() {
            public void run() {
                y.op();
            }
        };
        t2.setPriority(9);
        t2.start();
        }
    }
    

