package src.lr2.Task1;

import java.util.Random;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Size: ");
    int size = scanner.nextInt();

    scanner.close();

    int[] array = new int[size];

    Random random = new Random();
    for (int i = 0; i < size; i++) {
      array[i] = random.nextInt(10);
      System.out.println("array[" + i + "] = " + array[i]);

    }

    int min = array[0];

    for (int i = 1; i < size; i++) {
      if (array[i] < min) {
        min = array[i];
      }
    }

    System.out.println("\nMin value: " + min);
    System.out.print("Min value indexes: ");
    for (int i = 0; i < size; i++) {
      if (array[i] == min) {
        System.out.print(i + " ");
      }
    }
  }
}
