package src.lr7;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Example4 {
  public static void main(String[] args) {
    String fileName = "example_file.txt";
    String data = "Это данные для записи в файл";

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
      writer.write(data);
      System.out.println("Данные записаны в файл: " + fileName);
    } catch (IOException e) {
      System.out.println("Ошибка при записи в файл" + e.getMessage());
    }

    if (new File(fileName).delete()) {
      System.out.println("Файл удален: " + fileName);
    } else {
      System.out.println("Не удалось удалить файл" + fileName);
    }
  }
}
