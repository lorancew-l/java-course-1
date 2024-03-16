package src.timus;

import java.util.Locale;
import java.util.Scanner;

public class Task1263 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] input = scanner.nextLine().split(" ");
    int numCandidates = Integer.parseInt(input[0]);
    int numVoters = Integer.parseInt(input[1]);

    int[] votes = new int[numCandidates];

    for (int i = 0; i < numVoters; i++) {
      int candidate = scanner.nextInt();
      votes[candidate - 1]++;
    }

    scanner.close();

    Locale.setDefault(Locale.ENGLISH);
    for (int i = 0; i < numCandidates; i++) {
      double percentage = (double) votes[i] / numVoters * 100;
      System.out.printf("%.2f%%" + (i == numCandidates - 1 ? "" : "\n"), percentage);
    }
  }
}
