class Resource{
// Write Your Code Here
public synchronized void action(Resource otherResource){
    System.out.println(Thread.currentThread().getName()+": Holding"+this+" and waiting for "+otherResource);
    otherResource.action(this);
}
}
public class DeadLock{
    public static void main(String[] args) {
        Resource Resource1=new Resource();
        Resource Resource2=new Resource();
        Thread Thread1=new Thread(()->{
            synchronized (Resource1){
                System.out.println("Thread 1: Locked Resource 1");
                try{
                    Thread.sleep(100);
                    }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Thread 1: Trying to Lock Resource 2 ");
                synchronized (Resource2){
                    System.out.println("Thread 1: Locked Resource 2 ");
                }
            }
        });
        Thread Thread2=new Thread(()->{
            synchronized (Resource2){
                System.out.println("Thread 2: Locked Resource 2");
                try{
                    Thread.sleep(100);
                    }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Thread 2: Trying to Lock Resource 1 ");
                synchronized (Resource1){
                    System.out.println("Thread 2: Locked Resource 1 ");
                }
            }
        });
        Thread1.start();
        Thread2.start();
    }
}
