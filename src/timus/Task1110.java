package src.timus;

import java.math.BigInteger;
import java.util.Scanner;

public class Task1110 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int M = scanner.nextInt();
    int Y = scanner.nextInt();
    scanner.close();

    boolean found = false;
    for (int X = 0; X < M; X++) {
      if (bigMod(X, N, M) == Y) {
        System.out.print(X + " ");
        found = true;
      }
    }

    if (!found) {
      System.out.print("-1");
    }
  }

  static int bigMod(int a, int b, int m) {
    BigInteger A = BigInteger.valueOf(a);
    BigInteger B = BigInteger.valueOf(b);
    BigInteger M = BigInteger.valueOf(m);
    return A.modPow(B, M).intValue();
  }
}
