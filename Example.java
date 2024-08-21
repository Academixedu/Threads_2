public class Example{
// Preapare an Example for Inter Thread Communincation use wait() and Notify() Methods
public static double balance = 500;

    public synchronized void deposit(double dep) {
        balance = balance + dep;
        System.out.println("Deposit: " + dep);
        System.out.println("Balance: " + balance);
        notifyAll(); 
    }

    public synchronized void withdrawl(double withdraw) {
        while (balance <= withdraw) { 
            try {
                wait(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        balance = balance - withdraw;
        System.out.println("Withdrawal: " + withdraw);
        System.out.println("Balance: " + balance);
    }

}

