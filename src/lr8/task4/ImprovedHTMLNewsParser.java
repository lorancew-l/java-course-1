package lr8.task4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

public class ImprovedHTMLNewsParser {

  private static final String URL = "http://fat.urfu.ru/index.html";
  private static final int MAX_RETRIES = 5;
  private static final int RETRY_DELAY_MS = 3000;
  private static final String OUTPUT_FILE = "src/lr8/task4/news.txt";

  public static void main(String[] args) {
    Document doc = null;
    int attempts = 0;

    while (attempts < MAX_RETRIES) {
      try {
        System.out.println("Попытка получения документа");
        doc = Jsoup.connect(URL).get();
        System.out.println("Документ успешно получен");

        break;
      } catch (IOException e) {
        attempts++;
        System.err.println("Ошибка получения документа: " + e.getMessage());
        if (attempts < MAX_RETRIES) {
          System.err.println("Повторная попытка через " + (RETRY_DELAY_MS / 1000) + " секунд.");
          try {
            Thread.sleep(RETRY_DELAY_MS);
          } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
          }
        } else {
          System.err.println("Превышено максимальное количество попыток.");
          return;
        }
      }
    }

    if (doc != null) {
      Elements newsParent = doc.select("body> table > tbody>tr>td> div > table > "
          + "tbody> tr:nth-child(5) > td:nth-child(3) > table > tbody >" + "tr> td:nth-child(1)");

      try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
        for (int i = 3; i < 20; i++) {
          if (!(i % 2 == 0)) {
            List<Node> nodes = newsParent.get(0).childNodes();
            String title = "Тема: "
                + ((Element) nodes.get(i)).getElementsByClass("blocktitle").get(0).childNodes().get(0);
            String date = "Дата: " + ((Element) nodes.get(i)).getElementsByClass("blockdate").get(0).childNodes().get(0)
                + "\n";

            System.out.println(title);
            System.out.println(date);

            writer.write(title);
            writer.newLine();
            writer.write(date);
            writer.newLine();
          }
        }
      } catch (IOException e) {
        System.err.println("Ошибка записи в файл: " + e.getMessage());
      }
    }
  }
}