package src.lr5;

import java.util.Random;

class SumThread extends Thread {
  private int[] array;
  private int start;
  private int end;
  private int partialSum;

  public SumThread(int[] array, int start, int end) {
    this.array = array;
    this.start = start;
    this.end = end;
    this.partialSum = 0;
  }

  @Override
  public void run() {
    for (int i = start; i < end; i++) {
      partialSum += array[i];
    }
  }

  public int getPartialSum() {
    return partialSum;
  }
}

public class Task6 {
  private int[] array;
  private int numThreads;
  private int sum;

  public Task6(int[] array, int numThreads) {
    this.array = array;
    this.numThreads = numThreads;
    this.sum = 0;
  }

  public int sum() throws InterruptedException {
    int chunkSize = array.length / numThreads;
    SumThread[] threads = new SumThread[numThreads];

    int startIndex = 0;
    for (int i = 0; i < numThreads; i++) {
      int endIndex = (i == numThreads - 1) ? array.length : startIndex + chunkSize;
      threads[i] = new SumThread(array, startIndex, endIndex);
      threads[i].start();
      startIndex = endIndex;
    }

    for (SumThread thread : threads) {
      thread.join();
      sum += thread.getPartialSum();
    }

    return sum;
  }

  public static void main(String[] args) {
    int size = 1_000_000_000;
    int[] array = new int[size];

    Random random = new Random();
    for (int i = 0; i < size; i++) {
      array[i] = random.nextInt(10);
    }

    int numThreads = Runtime.getRuntime().availableProcessors();

    Task6 Task6 = new Task6(array, numThreads);

    try {
      long startTime = System.currentTimeMillis();
      int sum = Task6.sum();
      long time = System.currentTimeMillis() - startTime;
      System.out.println(String.format("Sum: %s | Time: %s | Threads: %s", sum, time, numThreads));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}