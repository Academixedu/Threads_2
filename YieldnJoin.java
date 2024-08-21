public class YieldnJoin extends Thread{
// Write Your Code Here
public void m1() {
    for (int i = 0; i < 10; i++) {
        System.out.println(i + ":" + Thread.currentThread().getName());
    }
}

public void m2() {
    for (int i = 0; i < 10; i++) {
        System.out.println(i + ":" + Thread.currentThread().getName());
    }
}

public static void main(String[] args) throws InterruptedException {
    YieldnJoin j = new YieldnJoin();
    Thread t = new Thread(() -> {
        j.m1();
    });
    t.start();

    Thread t1 = new Thread(() -> {
        j.m1();
    });
    t1.start();

    t1.join();

    Thread t3 = new Thread(() -> {
        j.m1();
    });
    t3.setName("Yield");
    t3.start();

    Thread.yield();
}
}

