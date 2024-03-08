package src.lr5;

import java.util.Random;

class FindMaxThread extends Thread {
  private int[] array;
  private int start;
  private int end;
  private int max = Integer.MIN_VALUE;

  public FindMaxThread(int[] array, int start, int end) {
    this.array = array;
    this.start = start;
    this.end = end;
  }

  @Override
  public void run() {
    for (int i = start; i < end; i++) {
      max = Math.max(max, array[i]);
    }
  }

  public int getMax() {
    return max;
  }
}

public class Task5 {
  public static int findMax(int[] array, int numThreads) throws InterruptedException {
    FindMaxThread[] threads = new FindMaxThread[numThreads];
    int chunkSize = array.length / numThreads;

    int startIndex = 0;
    for (int i = 0; i < numThreads; i++) {
      int endIndex = (i == numThreads - 1) ? array.length : startIndex + chunkSize;
      threads[i] = new FindMaxThread(array, startIndex, endIndex);
      threads[i].start();
      startIndex = endIndex;
    }

    int max = Integer.MIN_VALUE;
    for (FindMaxThread thread : threads) {
      thread.join();
      max = Math.max(max, thread.getMax());
    }

    return max;
  }

  public static void main(String[] args) {
    int size = 1_000_000_000;
    int[] array = new int[size];

    Random random = new Random();
    for (int i = 0; i < size; i++) {
      array[i] = random.nextInt(10);
    }

    int numThreads = Runtime.getRuntime().availableProcessors();

    try {
      long startTime = System.currentTimeMillis();
      int max = findMax(array, numThreads);
      long time = System.currentTimeMillis() - startTime;
      System.out.println(String.format("Max element: %s | Time: %s | Threads: %s", max, time, numThreads));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}