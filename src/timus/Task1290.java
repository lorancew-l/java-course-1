package src.timus;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Task1290 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    Integer[] arr = new Integer[N];

    for (int i = 0; i < N; i++) {
      arr[i] = scanner.nextInt();
    }

    scanner.close();

    Arrays.sort(arr, Collections.reverseOrder());

    for (int num : arr) {
      System.out.print(num + " ");
    }
  }
}
