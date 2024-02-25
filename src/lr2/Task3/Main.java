package src.lr2.Task3;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Введите текст для шифрования:");
    String text = scanner.nextLine();

    System.out.println("Введите ключ:");
    int key = scanner.nextInt();

    scanner.nextLine();

    CaesarCipher cipher = new CaesarCipher(key, 26, 'a');

    String encryptedText = cipher.encrypt(text);
    System.out.println("Текст после преобразования: " + encryptedText);

    boolean stop = false;
    while (!stop) {
      System.out.println("Выполнить обратное преобразование? (y/n)");
      String response = scanner.nextLine().trim().toLowerCase();

      if (response.equals("y")) {
        String decryptedText = cipher.decrypt(encryptedText);
        System.out.println("Текст после обратного преобразования: " + decryptedText);
        stop = true;
        break;
      } else if (response.equals("n")) {
        System.out.println("До свидания!");
        stop = true;
        break;
      } else {
        System.out.println("Введите корректный ответ.");
      }
    }

    scanner.close();
  }
}
