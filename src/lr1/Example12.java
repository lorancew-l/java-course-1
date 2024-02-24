package src.lr1;

import java.time.Year;
import java.util.Scanner;

public class Example12 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.println("Input age: ");
    int age = in.nextInt();

    Year year = Year.now();
    int birthYear = year.minusYears(age).getValue();

    String message = String.format("Your birth year is %s", birthYear);
    System.out.println(message);

    in.close();
  }
}
