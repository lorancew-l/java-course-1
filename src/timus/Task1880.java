package src.timus;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task1880 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    scanner.nextLine();
    String[] aArray = scanner.nextLine().split(" ");
    Set<Integer> aSet = new HashSet<>();
    for (String num : aArray) {
      aSet.add(Integer.parseInt(num));
    }

    scanner.nextLine();
    String[] bArray = scanner.nextLine().split(" ");
    Set<Integer> bSet = new HashSet<>();
    for (String num : bArray) {
      bSet.add(Integer.parseInt(num));
    }

    scanner.nextLine();
    String[] cArray = scanner.nextLine().split(" ");
    Set<Integer> cSet = new HashSet<>();
    for (String num : cArray) {
      cSet.add(Integer.parseInt(num));
    }

    int cnt = 0;
    for (int i : aSet) {
      if (bSet.contains(i) && cSet.contains(i)) {
        cnt++;
      }
    }

    scanner.close();
    System.out.print(cnt);
  }
}
