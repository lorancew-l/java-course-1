package src.timus;

import java.util.Scanner;

public class Task1409 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int harryShoots = scanner.nextInt();
    int larryShoots = scanner.nextInt();

    int totalShoots = harryShoots + larryShoots - 1;
    int harryMissed = totalShoots - harryShoots;
    int larryMissed = totalShoots - larryShoots;

    System.out.print(harryMissed + " " + larryMissed);
    scanner.close();
  }
}
