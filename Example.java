public class Example{
// Preapare an Example for Inter Thread Communincation use wait() and Notify() Methods
public static double balance=25000;
public synchronized  void deposit(double deposit){
    balance=balance+deposit;
    System.out.println("Deposit : "+deposit);
    System.out.println("Balance : "+balance);
    notify();
}
public synchronized void withdrawl(double withdraw){
if(balance<=withdraw){
    try {
        wait(100);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}    
else if(balance>withdraw){   
balance=balance-withdraw;
System.out.println("Withdrawl : "+withdraw);
System.out.println("Balance : "+balance);
}}
}



