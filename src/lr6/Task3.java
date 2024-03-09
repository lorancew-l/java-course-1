package src.lr6;

import java.util.List;
import java.util.stream.Collectors;

public class Task3 {
  public static void main(String[] args) {
    String string = "Напишите функцию, которая принимает на вход список"
        + "строк и возвращает новый список, содержащий только те строки, " +
        "которые начинаются с большой буквы.";

    List<String> strings = List.of(string.split(" "));
    System.out.println("\n" + "Строка после сплитования: " + "\n");
    for (String str : strings) {
      System.out.println(str);
    }

    List<String> stringsAfter = filterCapitalizedStrings(strings);

    System.out.println("\n" + "Строка после преобразования: " + "\n");
    for (String str : stringsAfter) {
      System.out.println(str);
    }
  }

  public static List<String> filterCapitalizedStrings(List<String> list) {
    return list.stream().filter(s -> Character.isUpperCase(s.charAt(0))).collect(Collectors.toList());
  }
}
