package src.lr1;

import java.time.Year;
import java.util.Scanner;

public class Example11 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.println("Input name: ");
    String name = in.nextLine();

    System.out.println("Input birth year: ");
    int birthYear = in.nextInt();

    Year year = Year.now();
    int age = year.minusYears(birthYear).getValue();

    String message = String.format("Your name is %s and you are %s years old", name, age);
    System.out.println(message);

    in.close();
  }
}
