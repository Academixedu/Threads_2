public class YieldnJoin {

    public static void main(String[] args) throws InterruptedException {
        Thread yieldThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Yield Thread - Count: " + i);
                Thread.yield();
            }
        });

        Thread joinThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Join Thread - Count: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        yieldThread.start();
        joinThread.start();
        joinThread.join();
        System.out.println("Thread completed");
    }
}
