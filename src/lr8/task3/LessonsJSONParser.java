package lr8.task3;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class LessonsJSONParser {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String filePath = "src/lr8/task3/lessons.json";

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
      JSONParser parser = new JSONParser();
      JSONObject library = (JSONObject) parser.parse(new FileReader(filePath));
      JSONArray lessons = (JSONArray) library.get("lessons");

      System.out.println("Введите название предмета:");
      String title = scanner.nextLine();
      System.out.println("Введите имя преподавателя:");
      String professor = scanner.nextLine();
      System.out.println("Введите год:");
      String year = scanner.nextLine();

      JSONObject lesson = new JSONObject();
      lesson.put("title", title);
      lesson.put("professor", professor);
      lesson.put("year", year);

      lessons.add(lesson);

      try (FileWriter file = new FileWriter(filePath)) {
        file.write(library.toJSONString());
        System.out.println("Предмет успешно добавлен!");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void searchLesson(String filePath, Scanner scanner) {
    try {
      JSONParser parser = new JSONParser();
      JSONObject library = (JSONObject) parser.parse(new FileReader(filePath));
      JSONArray lessons = (JSONArray) library.get("lessons");

      System.out.println("Введите название предмета для поиска (или оставьте пустым для поиска по году):");
      String searchTitle = scanner.nextLine();
      System.out.println("Введите год предмета для поиска (или оставьте пустым для поиска по названию):");
      String searchYear = scanner.nextLine();

      boolean found = false;
      Iterator<JSONObject> iterator = lessons.iterator();

      while (iterator.hasNext()) {
        JSONObject lesson = iterator.next();
        String title = (String) lesson.get("title");
        String year = (String) lesson.get("year").toString();

        if ((searchTitle.isEmpty() || title.equalsIgnoreCase(searchTitle)) &&
            (searchYear.isEmpty() || year.equalsIgnoreCase(searchYear))) {
          String professor = (String) lesson.get("professor");

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
      JSONParser parser = new JSONParser();
      JSONObject library = (JSONObject) parser.parse(new FileReader(filePath));
      JSONArray lessons = (JSONArray) library.get("lessons");

      System.out.println("Введите название предмета для удаления:");
      String deleteTitle = scanner.nextLine();

      boolean deleted = false;
      Iterator<JSONObject> iterator = lessons.iterator();

      while (iterator.hasNext()) {
        JSONObject lesson = iterator.next();
        String title = (String) lesson.get("title");

        if (title.equalsIgnoreCase(deleteTitle)) {
          iterator.remove();
          deleted = true;
          break;
        }
      }

      if (deleted) {
        try (FileWriter file = new FileWriter(filePath)) {
          file.write(library.toJSONString());
          System.out.println("Предмет успешно удален!");
        }
      } else {
        System.out.println("Предмет не найден.");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}