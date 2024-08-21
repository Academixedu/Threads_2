public class Example{
// Preapare an Example for Inter Thread Communincation use wait() and Notify() Methods
private int balance = 0;

    public synchronized void credit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount);
        notify(); // Notify waiting threads
    }

    public synchronized void debit(int amount) {
        if (balance < amount) {
            System.out.println("Insufficient balance;");
            try {
                wait(); // Wait for deposit
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        balance -= amount;
        System.out.println(Thread.currentThread().getName() + " withdraw " + amount);
        System.out.println("Balance after withdrawal: " + balance);
    }
}