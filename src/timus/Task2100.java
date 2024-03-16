package src.timus;

import java.util.Scanner;

public class Task2100 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    scanner.nextLine();

    int countPlusOne = 2;
    for (int i = 0; i < n; i++) {
      String response = scanner.nextLine();
      if (response.contains("+one")) {
        countPlusOne++;
      }
    }

    scanner.close();

    int totalGuests = n + countPlusOne;

    if (totalGuests == 13) {
      totalGuests++;
    }

    int totalCost = totalGuests * 100;

    System.out.print(totalCost);
  }
}
