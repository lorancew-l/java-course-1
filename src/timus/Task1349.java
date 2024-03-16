package src.timus;

import java.util.Scanner;

public class Task1349 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.close();
    int minA = 101, minB = 101, minC = 101;
    boolean found = false;

    for (int a = 1; a <= 100; a++) {
      for (int b = 1; b <= 100; b++) {
        for (int c = 1; c <= 100; c++) {
          if (Math.pow(a, n) + Math.pow(b, n) == Math.pow(c, n) && a != b && a != c && b != c) {
            found = true;

            if (a < minA || (a == minA && b < minB) || (a == minA && b == minB && c < minC)) {
              minA = a;
              minB = b;
              minC = c;
            }
          }
        }
      }
    }

    if (found) {
      System.out.print(minA + " " + minB + " " + minC);
    } else {
      System.out.print("-1");
    }
  }
}
