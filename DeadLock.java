class Resource {
    public synchronized void action(Resource otherResource) {
        System.out.println(Thread.currentThread().getName() + ": Holding " + this + " and waiting for " + otherResource);
        otherResource.action(this); // Try to acquire lock on the otherResource
    }
public class DeadLock{
// Write Your Code Here
}
public static void main(String[] args) {
    Resource resource1 = new Resource();
    Resource resource2 = new Resource();

    Thread thread1 = new Thread(() -> {
        synchronized (resource1) {
            System.out.println("Thread 1: Locked resource 1");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 1: Trying to lock resource 2");
            synchronized (resource2) {
                System.out.println("Thread 1: Locked resource 2");
            }
        }
    });

    Thread thread2 = new Thread(() -> {
        synchronized (resource2) {
            System.out.println("Thread 2: Locked resource 2");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 2: Trying to lock resource 1");
            synchronized (resource1) {
                System.out.println("Thread 2: Locked resource 1");
            }
        }
    });

    thread1.start();
    thread2.start();
}}
