package src.lr3.Task5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    HashMap<Integer, String> map = new HashMap<>();

    map.put(0, "Ноль");
    map.put(1, "Один");
    map.put(2, "Два");
    map.put(3, "Три");
    map.put(4, "Четыре");
    map.put(5, "Пять");
    map.put(6, "Шесть");
    map.put(7, "Семь");
    map.put(8, "Восемь");
    map.put(9, "Девять");

    List<String> greaterThan5 = map.keySet().stream().filter(key -> key > 5).map(Object::toString)
        .collect(Collectors.toList());

    if (map.containsKey(0)) {
      System.out.println("Ключи больше 5: " + String.join(", ", greaterThan5));
    }

    int product = map.entrySet().stream().filter(entry -> entry.getValue().length() > 5).mapToInt(Map.Entry::getKey)
        .reduce((a, b) -> a * b).getAsInt();

    System.out.println("Произведение ключей, где длина строки > 5: " + product);
  }
}
