public class Test{
// Create Thread Here and Test it Here of Logic Written in Example File
  // Apply Thread Class Priority() Method
  public static void main(String[] args) {
     Example d=new Example();
   
    Thread t=new Thread(){
        public void run(){  
    d.deposit(20000);
    }
    };
    t.start();
    Thread t1=new Thread(){
        public void run(){  
    d.withdrawl(10000);
    }
    };

    t1.start();

}
}




