public class Diff{
public synchronized  void m1(){
  for(int i=0; i<5;i++)
  {
    System.out.println(Thread.currentThread().getName());
  }

}

public static synchronized  void m2() {
  for(int i=0; i<5;i++)
  {
    System.out.println(Thread.currentThread().getName());
  }

}

public static void main(String[] args) {
  Diff d = new Diff();
  Thread t = new Thread()
  {
    public void run(){
      d.m1();
    }
  };t.start();

  Diff d2 = new Diff();
  Thread t2 = new Thread(){
    public void run(){
      d2.m2();
    }
  };
  t2.start();
}
}
