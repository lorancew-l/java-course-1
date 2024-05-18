package src.lr3.Task2;

import java.util.Scanner;

public class Main {
  public static String decimalToBinary(int n) {
    if (n == 0) {
      return "0";
    } else if (n == 1) {
      return "1";
    } else {
      return decimalToBinary(n / 2) + n % 2;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Введите целое число для перевода в двоичную систему: ");
    int number = scanner.nextInt();

    if (number < 0) {
      // Предположил, что подразумевается ввод только положительных чисел. Так как не
      // было задано, как представлять отрицательные
      System.out.println("Введите положительное число.");
    } else {
      String binary = decimalToBinary(number);
      System.out.println("Двоичное представление числа " + number + ": " + binary);
    }
    scanner.close();
  }
}
