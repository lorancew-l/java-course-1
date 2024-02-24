package src.lr1;

import java.util.Scanner;

public class Example7 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.println("Input name: ");
    String name = in.nextLine();

    System.out.println("Input age: ");
    int age = in.nextInt();

    String message = String.format("Your name is %s. You age is %s", name, age);
    System.out.println(message);

    in.close();
  }
}
