public class DeadLock{
// Write Your Code Here
   private static final Object lock1 = new Object();
   private  static final Object lock2 = new Object();

   public static void main(String[] args) {

    Thread thread1=new Thread(()->{
        synchronized (lock1) {
            System.out.println("Thread 1: lock 1");

            try {
                Thread.sleep(55);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2) {
                System.out.println("Thread 1: lock 2");
            }
        }
    });

    Thread thread2=new Thread(()->{
        synchronized (lock2) {
            System.out.println("Thread 2: lock 2");

            try {
                Thread.sleep(72);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock1) {
                System.out.println("Thread 2: lock 1");
            }
        }
    });

    thread1.start();
    thread2.start();
   }
}
