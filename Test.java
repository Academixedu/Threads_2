public class Test{
// Create Thread Here and Test it Here of Logic Written in Example File
  // Apply Thread Class Priority() Method
  public static void main(String[] args) {
    Example d = new Example();

    Thread t = new Thread(() -> {
        d.deposit(3490);
    });
    t.setPriority(Thread.MIN_PRIORITY);
    t.start();

    Thread t1 = new Thread(() -> {
        d.withdrawl(1000);
    });
    t1.setPriority(Thread.MAX_PRIORITY);
    t1.start();
}

}
