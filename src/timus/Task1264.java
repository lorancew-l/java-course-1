package src.timus;

import java.util.Scanner;

public class Task1264 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int M = scanner.nextInt();
    scanner.close();
    System.out.print(N * (M + 1));
  }
}
