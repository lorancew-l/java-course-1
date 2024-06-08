package lr8.task2;

import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class LessonsXMLParser {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String filePath = "src/lr8/task2/lessons.xml";

    while (true) {
      System.out.println("\nВыберите опцию:");
      System.out.println("1. Добавить предмет");
      System.out.println("2. Поиск предмета");
      System.out.println("3. Удалить предмет");
      System.out.println("4. Выход");

      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
          addLesson(filePath, scanner);
          break;
        case 2:
          searchLesson(filePath, scanner);
          break;
        case 3:
          deleteLesson(filePath, scanner);
          break;
        case 4:
          System.exit(0);
        default:
          System.out.println("Неверный выбор.");
      }
    }
  }

  private static void addLesson(String filePath, Scanner scanner) {
    try {
      DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
      Document doc = docBuilder.parse(filePath);

      Element rootElement = doc.getDocumentElement();

      System.out.println("Введите название предмета:");
      String title = scanner.nextLine();
      System.out.println("Введите имя преподавателя:");
      String professor = scanner.nextLine();
      System.out.println("Введите год:");
      String year = scanner.nextLine();

      Element lesson = doc.createElement("Lesson");
      rootElement.appendChild(lesson);

      Element titleElement = doc.createElement("title");
      titleElement.appendChild(doc.createTextNode(title));
      lesson.appendChild(titleElement);

      Element professorElement = doc.createElement("professor");
      professorElement.appendChild(doc.createTextNode(professor));
      lesson.appendChild(professorElement);

      Element yearElement = doc.createElement("year");
      yearElement.appendChild(doc.createTextNode(year));
      lesson.appendChild(yearElement);

      saveDocument(doc, filePath);
      System.out.println("Предмет успешно добавлен!");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void searchLesson(String filePath, Scanner scanner) {
    try {
      DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
      Document doc = docBuilder.parse(filePath);

      System.out.println("Введите название предмета для поиска (или оставьте пустым для поиска по году):");
      String searchTitle = scanner.nextLine();
      System.out.println("Введите год предмета для поиска (или оставьте пустым для поиска по названию):");
      String searchYear = scanner.nextLine();

      NodeList lessons = doc.getElementsByTagName("Lesson");
      boolean found = false;

      for (int i = 0; i < lessons.getLength(); i++) {
        Element lesson = (Element) lessons.item(i);
        String title = lesson.getElementsByTagName("title").item(0).getTextContent();
        String year = lesson.getElementsByTagName("year").item(0).getTextContent();

        if ((searchTitle.isEmpty() || title.equalsIgnoreCase(searchTitle)) &&
            (searchYear.isEmpty() || year.equalsIgnoreCase(searchYear))) {
          String professor = lesson.getElementsByTagName("professor").item(0).getTextContent();

          System.out.println("Предмет найден:");
          System.out.println("Название: " + title);
          System.out.println("Преподаватель: " + professor);
          System.out.println("Год: " + year + '\n');
          found = true;
        }
      }

      if (!found) {
        System.out.println("Предмет не найден.");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void deleteLesson(String filePath, Scanner scanner) {
    try {
      DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
      Document doc = docBuilder.parse(filePath);

      System.out.println("Введите название предмета для удаления:");
      String deleteTitle = scanner.nextLine();

      NodeList lessons = doc.getElementsByTagName("Lesson");
      boolean deleted = false;

      for (int i = 0; i < lessons.getLength(); i++) {
        Element lesson = (Element) lessons.item(i);
        String title = lesson.getElementsByTagName("title").item(0).getTextContent();

        if (title.equalsIgnoreCase(deleteTitle)) {
          lesson.getParentNode().removeChild(lesson);
          deleted = true;
          break;
        }
      }

      if (deleted) {
        saveDocument(doc, filePath);
        System.out.println("Предмет успешно удален!");
      } else {
        System.out.println("Предмет не найден.");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void saveDocument(Document doc, String filePath) throws Exception {
    javax.xml.transform.TransformerFactory tf = javax.xml.transform.TransformerFactory.newInstance();
    javax.xml.transform.Transformer transformer = tf.newTransformer();
    transformer.setOutputProperty(javax.xml.transform.OutputKeys.ENCODING, "UTF-8");
    transformer.setOutputProperty(javax.xml.transform.OutputKeys.STANDALONE, "yes");
    transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
    javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(doc);
    javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(new File(filePath));
    transformer.transform(source, result);
  }
}
