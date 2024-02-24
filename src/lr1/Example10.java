package src.lr1;

import java.time.Year;
import java.util.Scanner;

public class Example10 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.println("Input birth year: ");
    int birthYear = in.nextInt();

    Year year = Year.now();
    int age = year.minusYears(birthYear).getValue();

    String message = String.format("Your age is %s", age);
    System.out.println(message);

    in.close();
  }
}
