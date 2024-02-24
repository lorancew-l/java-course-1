package src.lr1;

import java.util.Scanner;

public class Example9 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.println("Input month: ");
    String month = in.nextLine();

    System.out.println("Input days in month: ");
    int dayCount = in.nextInt();

    String message = String.format("There are %s days in %s", dayCount, month);
    System.out.println(message);

    in.close();
  }
}
