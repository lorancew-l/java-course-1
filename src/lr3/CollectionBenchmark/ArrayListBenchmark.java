package src.lr3.CollectionBenchmark;

import java.util.ArrayList;

enum Position {
  Start,
  Middle,
  End
}

public class ArrayListBenchmark {
  static int itemCount = 500_000;
  static long itemCountAccessByIndex = 5_000_000L;

  public static void benchmarkAdd(Position position) {
    ArrayList<Integer> list = new ArrayList<Integer>();

    long startTime = System.currentTimeMillis();

    for (int i = 0; i < ArrayListBenchmark.itemCount; i++) {
      if (position == Position.Start) {
        list.addFirst(i);
      }

      if (position == Position.Middle) {
        list.add(list.size() / 2, i);
      }

      if (position == Position.End) {
        list.addLast(i);
      }
    }

    long timeMs = System.currentTimeMillis() - startTime;

    System.out.println(String.format("ArrayList add to %s time: %s ms", position, timeMs));
  }

  public static void benchmarkRemove(Position position) {
    ArrayList<Integer> list = new ArrayList<Integer>();

    for (int i = 0; i < ArrayListBenchmark.itemCount; i++) {
      list.add(i);
    }

    long startTime = System.currentTimeMillis();

    for (int i = 0; i < ArrayListBenchmark.itemCount; i++) {
      if (position == Position.Start) {
        list.removeFirst();
      }

      if (position == Position.Middle) {
        list.remove(list.size() / 2);
      }

      if (position == Position.End) {
        list.removeLast();
      }
    }

    long timeMs = System.currentTimeMillis() - startTime;

    System.out.println(String.format("ArrayList remove from %s time: %s ms", position, timeMs));
  }

  public static void benchmarkGet() {
    ArrayList<Integer> list = new ArrayList<Integer>();

    for (int i = 0; i < ArrayListBenchmark.itemCountAccessByIndex; i++) {
      list.add(i);
    }

    long startTime = System.currentTimeMillis();

    for (int i = 0; i < ArrayListBenchmark.itemCountAccessByIndex; i++) {
      list.get(i);
    }

    long timeMs = System.currentTimeMillis() - startTime;

    System.out.println(String.format("ArrayList get time: %s ms", timeMs));
  }

  public static void benchmark() {
    ArrayListBenchmark.benchmarkAdd(Position.Start);
    ArrayListBenchmark.benchmarkAdd(Position.Middle);
    ArrayListBenchmark.benchmarkAdd(Position.End);

    ArrayListBenchmark.benchmarkRemove(Position.Start);
    ArrayListBenchmark.benchmarkRemove(Position.Middle);
    ArrayListBenchmark.benchmarkRemove(Position.End);

    ArrayListBenchmark.benchmarkGet();
  }
}
