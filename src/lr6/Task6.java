package src.lr6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task6 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Введите количество чисел: ");
    int size = in.nextInt();

    List<Integer> numbers = new ArrayList<Integer>();

    in.nextLine();

    for (int i = 0; i < size; i++) {
      numbers.add(in.nextInt());
    }

    System.out.println("\n" + "Введите делитель: " + "\n");
    Integer divisor = in.nextInt();

    in.close();

    System.out.println("\n" + "Список чисел до преобразования: " + "\n");
    System.out.println(numbers.toString());

    List<Integer> numbersAfter = filterDivisibleNumbers(numbers, divisor);
    System.out.println("\n" + String.format("Список чисел после преобразования (делитель %s): ", divisor) + "\n");
    System.out.println(numbersAfter.toString());
  }

  public static List<Integer> filterDivisibleNumbers(List<Integer> list, int divisor) {
    return list.stream()
        .filter(num -> num % divisor == 0)
        .collect(Collectors.toList());
  }
}
