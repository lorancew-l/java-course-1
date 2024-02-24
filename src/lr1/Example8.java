package src.lr1;

import java.util.Scanner;

public class Example8 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.println("Input weekday: ");
    String weekday = in.nextLine();

    System.out.println("Input month: ");
    String month = in.nextLine();

    System.out.println("Input day: ");
    int day = in.nextInt();

    String message = String.format("Current day is %s %s %s", weekday, day, month);
    System.out.println(message);

    in.close();
  }
}
