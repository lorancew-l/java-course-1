package src.lr5;

class MyThread extends Thread {
  public void run() {
    System.out.println(Thread.currentThread().getName());
  }
}

public class Task4 {
  public static void main(String[] args) {
    for (int i = 1; i <= 10; i++) {
      Thread thread = new MyThread();
      thread.start();
    }
  }
}