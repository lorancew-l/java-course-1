package src.timus;

import java.util.Scanner;

public class Task1000 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String input = scanner.nextLine();
    scanner.close();
    String[] numbers = input.split(" ");

    int a = Integer.parseInt(numbers[0]);
    int b = Integer.parseInt(numbers[1]);

    int result = a + b;
    System.out.print(result);
  }
}
