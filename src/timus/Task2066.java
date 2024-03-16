package src.timus;

import java.util.Scanner;

public class Task2066 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a, b, c;
    a = scanner.nextInt();
    b = scanner.nextInt();
    c = scanner.nextInt();
    scanner.close();
    System.out.println(Math.min(a - b - c, Math.min(a - b * c, a * b - c)));
  }
}
