package src.lr2.Task2;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Rows: ");
    int rowCount = scanner.nextInt();

    System.out.println("Columns: ");
    int columnCount = scanner.nextInt();

    scanner.close();

    SnakeArray array = new SnakeArray(rowCount, columnCount);
    array.printArray();
  }
}
