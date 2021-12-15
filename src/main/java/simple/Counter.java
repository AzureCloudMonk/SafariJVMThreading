package simple;

class MyCounter implements Runnable {
  int counter = 0;
  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " Task starting");
    for (int i = 0; i < 100_000_000; i++) {
      counter++;
    }
    System.out.println(Thread.currentThread().getName() + " Task ending");
  }
}
public class Counter {
  public static void main(String[] args) throws Throwable {
    MyCounter mc = new MyCounter();
    Thread t1 = new Thread(mc);
    Thread t2 = new Thread(mc);
    t1.start();
    t2.start();
//    Thread.sleep(1000);
    t1.join();  // waits for t1's run() method to complete
    t2.join();
    System.out.println("count is " + mc.counter);
  }
}
