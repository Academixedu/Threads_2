public class Example{
// Preapare an Example for Inter Thread Communincation use wait() and Notify() Methods
private int balance = 0;
public synchronized void deposit(int amount) {
    balance += amount;
    System.out.println("Deposited: " + amount );
    System.out.println("Current Balance: " + balance);
    notify(); 
    }
    public synchronized void withdrawl(int amount) {
        if (balance < amount) {
            System.out.println("Insufficient balance. Waiting for deposit...");
            try {
                wait(); 
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        balance -= amount;
        System.out.println("Withdrawl: " + amount );
        System.out.println("Remaining Balance: " + balance);
    }
}
