package src.timus;

import java.util.Scanner;

public class Task2012 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int f = scanner.nextInt();
    scanner.close();

    if (f >= 12) {
      System.out.print("YES");
    } else {
      int remainingTasks = 12 - f;
      int remainingTime = 4 * 60;
      if (remainingTime >= remainingTasks * 45) {
        System.out.print("YES");
      } else {
        System.out.print("NO");
      }
    }
  }
}
