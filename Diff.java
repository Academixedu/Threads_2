public class Diff{
// Differentitae Synchronize static and Sunchronize with an Example 
  // Run it here by creating Thread Class Object
  // Diffrentiate Method Level Lock and Class Level Lock
  public synchronized void a1(){
    for(int i=1;i<=5;i++){
      System.out.println("method level lock");
      System.out.println("Static"+Thread.currentThread().getName());
  }
}
public static synchronized void a2(){
  for(int i=1;i<=5;i++){
    System.out.println("class level lock");
      System.out.println("Static"+Thread.currentThread().getName());
  }
}
public static void main(String args[]){
  Diff obj=new Diff();
  Thread thread1=new Thread(){
    public void run(){
      //obj.a1(); method level lock
      a2();
    }
  };thread1.start();
  Diff obj1=new Diff();
  Thread thread2=new Thread(){
    public void run(){
    //obj1.a1();//method level lock
     a2();
    }
  };thread2.start();
}
  }
  

