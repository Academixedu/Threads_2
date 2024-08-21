public class Example{
// Preapare an Example for Inter Thread Communincation use wait() and Notify() Methods
public static double balance = 300;

    public synchronized void deposit(double dep) {
        balance = balance + dep;
        System.out.println("Deposit: " + dep);
        System.out.println("Balance: " + balance);
        notify();
    }

    public synchronized void withdrawl(double withdraw) {
        if (balance <= withdraw) {
            try {
                wait(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            withdrawl(withdraw); // recursive call to re-attempt withdrawal
        } else if (balance > withdraw) {
            balance = balance - withdraw;
            System.out.println("Withdrawal: " + withdraw);
            System.out.println("Balance: " + balance);
        }
    }
}
