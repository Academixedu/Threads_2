public class Example {
    
        public static double balance=5000;
        public synchronized  void deposit(double dep){
            balance=balance+dep;
            System.out.println("Deposit : "+dep);
            System.out.println("Balance : "+balance);
            notify();
        }
        public synchronized void withdrawl(double withdraw){
        if(balance<=withdraw){
            try {
                wait(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }    
        else if(balance>withdraw){   
        balance=balance-withdraw;
        System.out.println("Withdrawl : "+withdraw);
        System.out.println("Balance : "+balance);
    }}
        }
    
    