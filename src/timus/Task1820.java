package src.timus;

import java.util.Scanner;

public class Task1820 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int k = scanner.nextInt();
    scanner.close();
    int minutes = Math.max(n / k + 1 + (n - 1 + n % k) / k, 2);
    System.out.print(minutes);
  }
}
