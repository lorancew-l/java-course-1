package src.lr7;

import java.io.File;
import java.util.Scanner;

public class Task5 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Введите путь к файлу:");
    String filePath = scanner.nextLine();

    File file = new File(filePath);

    if (file.exists()) {
      long fileSizeInBytes = file.length();
      System.out.println("Размер файла '" + filePath + "' составляет " + fileSizeInBytes + " байт(а).");
    } else {
      System.out.println("Файл не найден: " + filePath);
    }

    scanner.close();
  }
}
