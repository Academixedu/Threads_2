public class Test{
// Create Thread Here and Test it Here of Logic Written in Example File
  // Apply Thread Class Priority() Method

  public static void main(String[] args) {
    Example e = new Example();
    Thread t = new Thread()
    {
      public void run(){
        e.deposit(2500);
      }
    };
    t.setPriority(6);
    t.start();

    Thread t1=new Thread(){
      public void run(){  
  e.withdrawl(560);
  }
  };
  t1.setPriority(10);
  t1.start();

  }
}
