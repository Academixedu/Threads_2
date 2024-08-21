public class DeadLock{
// Write Your Code Here
public static void main(String[] args) {
    Resource resource1 = new Resource("Resource 1");
    Resource resource2 = new Resource("Resource 2");

    Thread thread1 = new Thread(() -> {
        synchronized (resource1) {
            System.out.println("Thread 1: Locked " + resource1);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 1: Trying to lock " + resource2);
            synchronized (resource2) {
                System.out.println("Thread 1: Locked " + resource2);
            }
        }
    });

    Thread thread2 = new Thread(() -> {
        synchronized (resource2) {
            System.out.println("Thread 2: Locked " + resource2);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 2: Trying to lock " + resource1);
            synchronized (resource1) {
                System.out.println("Thread 2: Locked " + resource1);
            }
        }
    });
    thread1.start();
        thread2.start();
    }

    static class Resource {
        private String name;

        public Resource(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }


}
    