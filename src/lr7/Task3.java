package src.lr7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task3 {
  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Введите имя исходного файла: ");
    String sourceFileName = scanner.nextLine();

    scanner.close();

    File file = new File(sourceFileName);
    if (!file.exists() || !file.isFile()) {
      System.out.println("Файл не существует");
      return;
    }

    BufferedReader reader = new BufferedReader(new FileReader(file));

    int lineCount = 0;
    while (reader.readLine() != null) {
      lineCount++;
    }
    reader.close();
    System.out.println("Количество строк в файле: " + lineCount);
  }
}
