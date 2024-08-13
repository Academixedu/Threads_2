public class YieldnJoin{
    // Write Your Code Here
    
        public static void main(String[] args) throws InterruptedException {
            // Create two threads
            Thread thread1 = new Thread(){
                public void run(){
                    for(int i=0;i<5;i++){
                        System.out.println("Thread 1");
                    }
                }
            };
            Thread thread2 = new Thread(){
                public void run(){
                    for(int i=0;i<5;i++){
                        System.out.println("Thread 2");
                    }
                }
            };
            thread1.start();
            thread2.start();
            thread1.yield();
            thread2.join();
            for(int i=0;i<5;i++){
                System.out.println("Main Thread");
            }   
            }
        }
