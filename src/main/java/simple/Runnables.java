package simple;

class MyTask implements Runnable {
  private String name;

  public MyTask(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " Task starting");
    for (int i = 0; i < 100; i++) {
      System.out.println(Thread.currentThread().getName() + " i is " + i);
    }
    System.out.println(Thread.currentThread().getName() + " Task ending");
  }
}

public class Runnables {
  public static void main(String[] args) {
    System.out.println(Thread.currentThread().getName() + " starting");
    MyTask t = new MyTask("Fred's Task");
//    t.run();
    Thread t1 = new Thread(t);
    Thread t2 = new Thread(t);
//    t1.setDaemon(true);
    t1.start();
    t2.start();
    System.out.println(Thread.currentThread().getName() + " ending");
  }
}
