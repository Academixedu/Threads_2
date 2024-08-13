import java.io.*;
import java.util.*;

//Thread by using Runnable Interface

public class Subhash implements Runnable {
    // method to start Thread
    public void run()
    {
        System.out.println(
            "Thread is Running Successfully");
    }

    public static void main(String[] args)
    {
        Subhash g1 = new Subhash();
        // initializing Thread Object
        Thread t1 = new Thread(g1);
        t1.start();
    }
}
