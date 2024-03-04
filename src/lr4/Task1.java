package src.lr4;

import java.util.Scanner;

class NoPositiveNumbersException extends Exception {
  public NoPositiveNumbersException() {
    super("Положительные элементы отсутствуют");
  }
}

public class Task1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    try {
      System.out.print("Введите размер массива: ");
      int size = scanner.nextInt();
      int[] array = new int[size];

      System.out.println("Введите элементы массива:");
      for (int i = 0; i < size; i++) {
        array[i] = scanner.nextInt();
      }

      double average = calculatePositiveAverage(array);
      System.out.println("Среднее значение положительных элементов массива: " + average);
    } catch (java.util.InputMismatchException e) {
      if (e.getMessage() == null) {
        System.out.println("Ошибка: введена строка вместо числа или число несоответствует типу данных");
      } else if (e.getMessage().contains("out of range")) {
        System.out.println("Ошибка: Введенное число выходит за пределы допустимого диапазона");
      } else if (e.getMessage().contains("does not match pattern")) {
        System.out.println("Ошибка: Введена строка вместо числа");
      } else {
        System.out.println("Ошибка: " + e.getMessage());
      }
    } catch (NegativeArraySizeException e) {
      System.out.println("Ошибка: введен отрицательный размер массива");
    } catch (NoPositiveNumbersException e) {
      System.out.println(String.format("Ошибка: %s", e.getMessage()));
    }

    scanner.close();
  }

  public static double calculatePositiveAverage(int[] array) throws NoPositiveNumbersException {
    int sum = 0;
    int count = 0;

    for (int num : array) {
      if (num > 0) {
        sum += num;
        count++;
      }
    }

    if (count == 0) {
      throw new NoPositiveNumbersException();
    }

    return (double) sum / count;
  }
}
