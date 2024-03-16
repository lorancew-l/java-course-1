package src.timus;

import java.util.Scanner;

public class Task1197 {
  public static int countAttackedSquares(char file, int rank) {
    int[] dx = { 2, 1, -1, -2, -2, -1, 1, 2 };
    int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };

    int count = 0;
    for (int i = 0; i < 8; i++) {
      int x = file - 'a' + 1 + dx[i];
      int y = rank + dy[i];
      if (x >= 1 && x <= 8 && y >= 1 && y <= 8) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    scanner.nextLine();

    char[] files = new char[N];
    int[] ranks = new int[N];
    for (int i = 0; i < N; i++) {
      String position = scanner.nextLine();
      files[i] = position.charAt(0);
      ranks[i] = Character.getNumericValue(position.charAt(1));
    }

    for (int i = 0; i < N; i++) {
      int attackedSquares = countAttackedSquares(files[i], ranks[i]);
      System.out.print(attackedSquares + (i == N - 1 ? "" : "\n"));
    }

    scanner.close();
  }
}
