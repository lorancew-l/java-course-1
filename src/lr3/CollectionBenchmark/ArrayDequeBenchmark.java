package src.lr3.CollectionBenchmark;

import java.util.ArrayList;

enum Position {
  Start,
  Middle,
  End
}

public class ArrayDequeBenchmark {
  static int itemCount = 500_000;
  static long itemCountAccessByIndex = 5_000_000L;

  public static void benchmarkAdd(Position position) {
    ArrayList<Integer> arrayDeque = new ArrayList<Integer>();

    long startTime = System.currentTimeMillis();

    for (int i = 0; i < ArrayDequeBenchmark.itemCount; i++) {
      if (position == Position.Start) {
        arrayDeque.addFirst(i);
      }

      if (position == Position.Middle) {
        arrayDeque.add(arrayDeque.size() / 2, i);
      }

      if (position == Position.End) {
        arrayDeque.addLast(i);
      }
    }

    long timeMs = System.currentTimeMillis() - startTime;

    System.out.println(String.format("ArrayDeque add to %s time: %s ms", position, timeMs));
  }

  public static void benchmarkRemove(Position position) {
    ArrayList<Integer> arrayDeque = new ArrayList<Integer>();

    for (int i = 0; i < ArrayDequeBenchmark.itemCount; i++) {
      arrayDeque.add(i);
    }

    long startTime = System.currentTimeMillis();

    for (int i = 0; i < ArrayDequeBenchmark.itemCount; i++) {
      if (position == Position.Start) {
        arrayDeque.removeFirst();
      }

      if (position == Position.Middle) {
        arrayDeque.remove(arrayDeque.size() / 2);
      }

      if (position == Position.End) {
        arrayDeque.removeLast();
      }
    }

    long timeMs = System.currentTimeMillis() - startTime;

    System.out.println(String.format("ArrayDeque remove from %s time: %s ms", position, timeMs));
  }

  public static void benchmarkGet() {
    ArrayList<Integer> arrayDeque = new ArrayList<Integer>();

    for (int i = 0; i < ArrayDequeBenchmark.itemCountAccessByIndex; i++) {
      arrayDeque.add(i);
    }

    long startTime = System.currentTimeMillis();

    for (int i = 0; i < ArrayDequeBenchmark.itemCountAccessByIndex; i++) {
      arrayDeque.get(i);
    }

    long timeMs = System.currentTimeMillis() - startTime;

    System.out.println(String.format("ArrayDeque get time: %s ms", timeMs));
  }

  public static void benchmark() {
    ArrayDequeBenchmark.benchmarkAdd(Position.Start);
    ArrayDequeBenchmark.benchmarkAdd(Position.Middle);
    ArrayDequeBenchmark.benchmarkAdd(Position.End);

    ArrayDequeBenchmark.benchmarkRemove(Position.Start);
    ArrayDequeBenchmark.benchmarkRemove(Position.Middle);
    ArrayDequeBenchmark.benchmarkRemove(Position.End);

    ArrayDequeBenchmark.benchmarkGet();
  }
}
