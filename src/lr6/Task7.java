package src.lr6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task7 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Введите количество строк: ");
    int size = in.nextInt();

    List<String> strings = new ArrayList<String>();

    in.nextLine();

    for (int i = 0; i < size; i++) {
      strings.add(in.nextLine());
    }

    System.out.println("\n" + "Введите минимальную длину: " + "\n");
    int minLength = in.nextInt();

    in.close();

    System.out.println("\n" + "Список строк до преобразования: " + "\n");
    for (String str : strings) {
      System.out.println(str);
    }

    List<String> stringsAfter = filterStringsByLength(strings, minLength);
    System.out.println("\n" + String.format("Список строк после преобразования (мин. длина %s): ", minLength) + "\n");
    for (String str : stringsAfter) {
      System.out.println(str);
    }
  }

  public static List<String> filterStringsByLength(List<String> list, int minLength) {
    return list.stream()
        .filter(str -> str.length() > minLength)
        .collect(Collectors.toList());
  }
}
