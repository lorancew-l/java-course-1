package src.lr4;

import java.util.Scanner;

public class Task3 {
  public static byte addByteWithOverflowCheck(byte a, byte b) {
    int result = (int) a + (int) b;
    if (result < Byte.MIN_VALUE || result > Byte.MAX_VALUE) {
      throw new ArithmeticException("Переполнение при сложении");
    }
    return (byte) result;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    try {
      System.out.print("Введите размер массива: ");
      int size = scanner.nextInt();

      byte[] array = new byte[size];

      System.out.println("Введите элементы массива: ");
      for (int i = 0; i < size; i++) {
        array[i] = scanner.nextByte();
      }

      byte sum = 0;
      for (byte num : array) {
        sum = addByteWithOverflowCheck(sum, num);
      }

      System.out.println("Сумма элементов массива: " + sum);

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
    } catch (java.lang.ArithmeticException e) {
      System.out.println("Ошибка: переполнение при вычислении суммы");
    } catch (NegativeArraySizeException e) {
      System.out.println("Ошибка: введен отрицательный размер массива");
    } finally {
      scanner.close();
    }
  }
}