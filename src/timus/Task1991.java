package src.timus;

import java.util.Scanner;

public class Task1991 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int k = scanner.nextInt();
    int[] bombs = new int[n];

    for (int i = 0; i < n; i++) {
      bombs[i] = scanner.nextInt();
    }

    scanner.close();

    int unusedBombs = 0;
    int survivedDroids = 0;

    for (int i = 0; i < n; i++) {
      int droidsInBlock = k;
      int bombsInPart = bombs[i];

      if (bombsInPart >= droidsInBlock) {
        survivedDroids += 0;
        unusedBombs += bombsInPart - droidsInBlock;
      } else {
        survivedDroids += droidsInBlock - bombsInPart;
        unusedBombs += 0;
      }
    }

    System.out.print(unusedBombs + " " + survivedDroids);
  }
}
