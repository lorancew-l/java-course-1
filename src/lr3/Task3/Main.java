package src.lr3.Task3;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Введите размер массива: ");
    int size = scanner.nextInt();
    int[] array = new int[size];

    System.out.print("\n");

    inputArray(array, 0, scanner);

    System.out.println("\nМассив:");
    outputArray(array, 0);

    scanner.close();
  }

  public static void inputArray(int[] array, int index, Scanner scanner) {
    if (index < array.length) {
      System.out.print("Введите элемент " + (index + 1) + ": ");
      array[index] = scanner.nextInt();
      inputArray(array, index + 1, scanner);
    }
  }

  public static void outputArray(int[] array, int index) {
    if (index < array.length) {
      System.out.println(array[index]);
      outputArray(array, index + 1);
    }
  }
}
