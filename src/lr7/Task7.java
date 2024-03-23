package src.lr7;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task7 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Введите название файла: ");
    String fileName = scanner.nextLine();

    System.out.print("Введите текст для записи в файл: ");
    String text = scanner.nextLine();

    scanner.close();

    int writtenCharactersCount = 0;

    try {
      File file = new File(fileName);
      if (!file.exists()) {
        file.createNewFile();
      }

      try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
        writer.write(text);
        writtenCharactersCount = text.length();
      }
    } catch (IOException e) {
      System.err.println("Ошибка при записи в файл: " + e.getMessage());
    }

    System.out.println("Количество записанных символов: " + writtenCharactersCount);
  }
}
