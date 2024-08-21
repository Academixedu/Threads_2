public class Test1{
// Create Thread Here and Test it Here of Logic Written in Example File
  // Apply Thread Class Priority() Method
    public static void main(String[] args) {
        Example account = new Example();

        Thread depositThread = new Thread(() -> {
            synchronized(account) {
                account.credit(1111111);
            }
        });
        depositThread.setPriority(Thread.NORM_PRIORITY);
        depositThread.setName("Deposit");

        Thread withdrawThread = new Thread(() -> {
            synchronized(account) {
                account.debit(55555);
            }
        });
        withdrawThread.setPriority(Thread.MAX_PRIORITY);
        withdrawThread.setName("Withdrawal");

        depositThread.start();
        withdrawThread.start();
    }
}
