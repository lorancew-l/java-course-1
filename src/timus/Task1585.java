package src.timus;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task1585 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    scanner.nextLine();

    Map<String, Integer> penguinCount = new HashMap<>();

    for (int i = 0; i < n; i++) {
      String penguinType = scanner.nextLine();
      penguinCount.put(penguinType, penguinCount.getOrDefault(penguinType, 0) + 1);
    }

    scanner.close();

    String mostCommonPenguin = "";
    int maxCount = 0;
    for (Map.Entry<String, Integer> entry : penguinCount.entrySet()) {
      if (entry.getValue() > maxCount) {
        mostCommonPenguin = entry.getKey();
        maxCount = entry.getValue();
      }
    }

    System.out.print(mostCommonPenguin);
  }
}
