package src.timus;

import java.util.Scanner;

public class Task1243 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    scanner.close();

    int numDwarfs = 7;
    int remainder = customDivision(input, numDwarfs);

    System.out.print(remainder);
  }

  public static int customDivision(String input, int divisor) {
    int remainder = 0;
    for (int i = 0; i < input.length(); i++) {
      int digit = input.charAt(i) - '0';
      remainder = (remainder * 10 + digit) % divisor;
    }
    return remainder;
  }
}
