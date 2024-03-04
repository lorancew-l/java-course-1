package src.lr4;

import java.util.Random;
import java.util.Scanner;

class ZeroMatrixDimensionException extends Exception {
  public ZeroMatrixDimensionException(String message) {
    super(message);
  }
}

public class Task2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int rows = 0;
    int columns = 0;

    try {
      System.out.print("Введите количество строк матрицы: ");
      rows = scanner.nextInt();
      if (rows == 0) {
        throw new ZeroMatrixDimensionException("Размерность строк матрицы должна быть больше 0");
      }

      System.out.print("Введите количество столбцов матрицы: ");
      columns = scanner.nextInt();

      if (columns == 0) {
        throw new ZeroMatrixDimensionException("Размерность колонок матрицы должна быть больше 0");
      }
    } catch (java.util.InputMismatchException e) {
      System.out.println("Ошибка: Введено некорректное значение. Ожидается целое число.");
      scanner.close();
      return;
    } catch (ZeroMatrixDimensionException e) {
      System.out.println(String.format("Ошибка: %s", e.getMessage()));
      scanner.close();
      return;
    }

    int[][] matrix = new int[rows][columns];

    System.out.println("Матрица:");

    Random random = new Random();

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        matrix[i][j] = random.nextInt(5);
        System.out.print(matrix[i][j] + "\t");
      }
      System.out.println();
    }

    System.out.print("Введите индекс столбца: ");
    try {
      int columnToPrint = scanner.nextInt();

      if (columnToPrint < 0 || columnToPrint >= columns) {
        System.out.println("Ошибка: Нет столбца с таким индексом");
      } else {
        System.out.println("Столбец с индексом " + columnToPrint + ":");
        for (int i = 0; i < rows; i++) {
          System.out.println(matrix[i][columnToPrint]);
        }
      }
    } catch (java.util.InputMismatchException e) {
      System.out.println("Ошибка: Введено некорректное значение. Введите целое число.");
    } finally {
      scanner.close();
    }
  }
}