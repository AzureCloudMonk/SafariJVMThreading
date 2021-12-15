package simple;

public class Visibility {
  static volatile boolean stop = false;

  public static void main(String[] args) throws Throwable {
    new Thread(() -> {
      System.out.println(Thread.currentThread().getName() + " starting");

      while (! stop)
        ;

      System.out.println(Thread.currentThread().getName() + " ending");
    }).start();

    System.out.println(Thread.currentThread().getName() + " worker launched");
    Thread.sleep(1000);
    System.out.println(Thread.currentThread().getName()
        + " setting stop flag");
    stop = true;
    System.out.println(Thread.currentThread().getName()
        + " stop flag set to " + stop + " main exiting");
  }
}
