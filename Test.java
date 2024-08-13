public class Test {
  public static void main(String[] args) {
      Thread highPriorityThread = new Thread(() -> {
          for (int i = 0; i < 5; i++) {
              System.out.println("High Priority Thread - Count: " + i);
              try {
                  Thread.sleep(100);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
      });
      highPriorityThread.setPriority(Thread.MAX_PRIORITY);
      Thread lowPriorityThread = new Thread(() -> {
          for (int i = 0; i < 5; i++) {
              System.out.println("Low Priority Thread - Count: " + i);
              try {
                  Thread.sleep(100);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
      });
      lowPriorityThread.setPriority(Thread.MIN_PRIORITY);
      highPriorityThread.start();
      lowPriorityThread.start();
  }
}
