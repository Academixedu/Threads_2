 public class Example{
// Preapare an Example for Inter Thread Communincation use wait() and Notify() Methods
  private int balance = 0;
    public synchronized void deposit(int amount) {
        System.out.println("Depositing: " + amount);
        balance += amount;
        System.out.println("Deposit complete. Current balance: " + balance);
        notify(); 
    }

  
    public synchronized void withdrawl(int amount) {
        System.out.println("Attempting to withdraw: " + amount);
        while (balance < amount) {
            System.out.println("Insufficient balance. Waiting for deposit...");
            try {
                wait(); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        balance -= amount;
        System.out.println("Withdrawal complete. Current balance: " + balance);
    }
}

public class WaitndNotify {
    public static void main(String[] args) {
        Example d = new Example();

     
        Thread t = new Thread() {
            public void run() {
                d.deposit(230000);
            }
        };
        t.setPriority(1);

   
        Thread t1 = new Thread() {
            public void run() {
                d.withdrawl(5600);
            }
        };
        t1.setPriority(10);

       
        t1.start();
        t.start(); 
    }
}
