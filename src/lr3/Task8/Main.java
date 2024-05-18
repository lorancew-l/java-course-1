package src.lr3.Task8;

public class Main {
  public static void main(String[] args) {
    System.out.println("Тестирование методов на основе цикла:");

    // Создание связанного списка
    LinkedList<Integer> linkedList;

    // Ввод с головы
    linkedList = new LinkedList<>();
    Integer[] values = { 1, 2, 3, 4, 5 };
    linkedList.createHead(values);
    System.out.println("Исходный список:" + linkedList.toString());
    System.out.println("Список (ввод с головы):" + linkedList.toString());

    // Ввод с хвоста
    linkedList = new LinkedList<>();
    linkedList.createTail(values);
    System.out.println("Список (ввод с хвоста):" + linkedList.toString());

    // Добавление элемента в начало списка
    linkedList = new LinkedList<>();
    linkedList.createHead(values);
    linkedList.addFirst(0);
    System.out.println("Список (добавление в начало):" + linkedList.toString());

    // Добавление элемента в конец списка
    linkedList = new LinkedList<>();
    linkedList.createHead(values);
    linkedList.addLast(6);
    System.out.println("Список (добавление в конец):" + linkedList.toString());

    // Вставка элемента в список с указанным номером
    linkedList = new LinkedList<>();
    linkedList.createHead(values);
    linkedList.insert(2, 10);
    System.out.println("Список (вставка на позицию 2):" + linkedList.toString());

    // Удаление элемента с головы списка
    linkedList = new LinkedList<>();
    linkedList.createHead(values);
    linkedList.removeFirst();
    System.out.println("Список (удаление с головы):" + linkedList.toString());

    // Удаление последнего элемента списка
    linkedList = new LinkedList<>();
    linkedList.createHead(values);
    linkedList.removeLast();
    System.out.println("Список (удаление с хвоста):" + linkedList.toString());

    // Удаление из списка элемента с указанным номером
    linkedList = new LinkedList<>();
    linkedList.createHead(values);
    linkedList.removeAt(2);
    System.out.println("Список (удаление элемента на позиции 2):" + linkedList.toString());

    System.out.println("\nТестирование методов на основе рекурсии:");

    // Создание нового связанного списка
    LinkedList<Integer> recursiveList;

    // Ввод с головы с использованием рекурсии
    recursiveList = new LinkedList<>();
    recursiveList.createHeadRec(values);
    System.out.println("Список (ввод с головы с рекурсией):" + recursiveList.toStringRec());

    // Ввод с хвоста с использованием рекурсии
    recursiveList = new LinkedList<>();
    recursiveList.createTailRec(values);
    System.out.println("Список (ввод с хвоста с рекурсией):" + recursiveList.toStringRec());
  }
}
