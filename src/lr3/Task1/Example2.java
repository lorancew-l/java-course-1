package src.lr3.Task1;

public class Example2 {
  public static void m(int x) {
    int nextX = 2 * x + 1;

    if (nextX < 20) {
      m(nextX);
    }

    System.out.println("x=" + x);
  }

  public static void main(String[] args) {
    m(1);
  }
}
