package src.lr6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task9 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Введите количество строк: ");
    int size = in.nextInt();

    List<String> strings = new ArrayList<String>();

    in.nextLine();

    for (int i = 0; i < size; i++) {
      strings.add(in.nextLine());
    }

    in.close();

    System.out.println("\n" + "Список строк до преобразования: " + "\n");
    for (String str : strings) {
      System.out.println(str);
    }

    List<String> stringsAfter = filterStringsWithLetters(strings);
    System.out.println("\n" + "Список строк после преобразования: " + "\n");
    for (String str : stringsAfter) {
      System.out.println(str);
    }
  }

  public static List<String> filterStringsWithLetters(List<String> inputList) {
    return inputList.stream()
        .filter(str -> str.replaceAll("\\s+", "").chars().allMatch(Character::isLetter))
        .collect(Collectors.toList());
  }
}
