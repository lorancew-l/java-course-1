package src.timus;

import java.util.Scanner;

public class Task1785 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int monsters = scanner.nextInt();
    String localization = localizeMonsters(monsters);
    System.out.print(localization);
    scanner.close();
  }

  public static String localizeMonsters(int count) {
    if (count >= 1 && count <= 4) {
      return "few";
    } else if (count >= 5 && count <= 9) {
      return "several";
    } else if (count >= 10 && count <= 19) {
      return "pack";
    } else if (count >= 20 && count <= 49) {
      return "lots";
    } else if (count >= 50 && count <= 99) {
      return "horde";
    } else if (count >= 100 && count <= 249) {
      return "throng";
    } else if (count >= 250 && count <= 499) {
      return "swarm";
    } else if (count >= 500 && count <= 999) {
      return "zounds";
    } else if (count >= 1000) {
      return "legion";
    } else {
      return "Invalid input";
    }
  }
}
