package src.lr1;

import java.util.Scanner;

public class Example13 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.println("Input first number: ");
    int firstNumber = in.nextInt();

    System.out.println("Input second number: ");
    int secondNumber = in.nextInt();

    int sum = firstNumber + secondNumber;

    String message = String.format("Sum is %s", sum);
    System.out.println(message);

    in.close();
  }
}
