package src.lr7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task6 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Введите имя файла: ");
    String fileName = scanner.nextLine();

    System.out.print("Введите слово для поиска: ");
    String textToSearch = scanner.nextLine();

    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.contains(textToSearch)) {
          System.out.println(line);
        }
      }
    } catch (IOException e) {
      System.err.println("Ошибка при чтении файла: " + e.getMessage());
    } finally {
      scanner.close();
    }
  }
}
