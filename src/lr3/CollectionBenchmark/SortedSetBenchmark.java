package src.lr3.CollectionBenchmark;

import java.util.SortedSet;
import java.util.TreeSet;

enum Position {
  Start,
  Middle,
  End
}

public class SortedSetBenchmark {
  static int itemCount = 500_000;
  static long itemCountAccessByIndex = 5_000_000L;

  public static void benchmarkAdd() {
    SortedSet<Integer> set = new TreeSet<Integer>();

    long startTime = System.currentTimeMillis();

    for (int i = 0; i < SortedSetBenchmark.itemCount; i++) {
      set.add(i);
    }

    long timeMs = System.currentTimeMillis() - startTime;

    System.out.println(String.format("SortedSet add time: %s ms", timeMs));
  }

  public static void benchmarkRemove(Position position) {
    SortedSet<Integer> set = new TreeSet<Integer>();

    for (int i = 0; i < SortedSetBenchmark.itemCount; i++) {
      set.add(i);
    }

    long startTime = System.currentTimeMillis();

    for (int i = 0; i < SortedSetBenchmark.itemCount; i++) {
      if (position == Position.Start) {
        set.removeFirst();
      }

      if (position == Position.Middle) {
        set.remove(set.size() / 2);
      }

      if (position == Position.End) {
        set.removeLast();
      }
    }

    long timeMs = System.currentTimeMillis() - startTime;

    System.out.println(String.format("SortedSet remove from %s time: %s ms", position, timeMs));
  }

  public static void benchmarkGet() {
    SortedSet<Integer> set = new TreeSet<Integer>();

    for (int i = 0; i < SortedSetBenchmark.itemCountAccessByIndex; i++) {
      set.add(i);
    }

    long startTime = System.currentTimeMillis();

    for (int i = 0; i < SortedSetBenchmark.itemCountAccessByIndex; i++) {
      set.last();
    }

    long timeMs = System.currentTimeMillis() - startTime;

    System.out.println(String.format("SortedSet get time: %s ms", timeMs));
  }

  public static void benchmark() {
    SortedSetBenchmark.benchmarkAdd();

    SortedSetBenchmark.benchmarkRemove(Position.Start);
    SortedSetBenchmark.benchmarkRemove(Position.Middle);
    SortedSetBenchmark.benchmarkRemove(Position.End);

    SortedSetBenchmark.benchmarkGet();
  }
}
