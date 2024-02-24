package src.lr1;

import java.util.Scanner;

public class Example14 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.println("Input number: ");
    int number = in.nextInt();

    int previousNumber = number - 1;
    int nextNumber = number + 1;

    double square = Math.pow(previousNumber + number + nextNumber, 2);

    String message = String.format("%s %s %s %s", previousNumber, number, nextNumber, square);
    System.out.println(message);

    in.close();
  }
}
