public class Diff{
// Differentitae Synchronize static and Sunchronize with an Example 
  // Run it here by creating Thread Class Object
  // Diffrentiate Method Level Lock and Class Level Lock
  public  synchronized void MethodLevel(){
    for(int i=0;i<=5;i++){
      System.out.println("Method-Level-Object"+Thread.currentThread().getName());
    }
  }
  public static  synchronized void ClassLevel(){
    for(int i=0;i<=5;i++){
      System.out.println("Class-Level-Object "+Thread.currentThread().getName());
    }
  }
  public static void main(String[] args) {
    Diff syn =new Diff();
    Thread t=new Thread(){
      public void run(){
          //syn.MethodLevel();
          ClassLevel();
      
      }
  }; 
  t.start();
  
  Thread t1=new Thread(){
    public void run(){
        ClassLevel();
    
    }
}; 
t1.start();
}
}

