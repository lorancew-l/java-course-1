package src.timus.task_1293;

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    int N = in.nextInt();
    int A = in.nextInt();
    int B = in.nextInt();

    int sulphideCount = N * A * B * 2;

    out.println(sulphideCount);
    out.flush();

    out.close();
    in.close();
  }
}
