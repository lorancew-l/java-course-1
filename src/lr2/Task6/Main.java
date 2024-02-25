package src.lr2.Task6;

public class Main {
  public static void main(String[] args) {
    IShape circle = new Circle(4);
    IShape square = new Square(2);
    IShape triangle = new Triangle(3, 4, 5);

    System.out.println("Circle area: " + circle.getArea());
    System.out.println("Circle perimeter: " + circle.getPerimeter());

    System.out.println("Square area: " + square.getArea());
    System.out.println("Square perimeter: " + square.getPerimeter());

    System.out.println("Triangle area: " + triangle.getArea());
    System.out.println("Triangle perimeter: " + triangle.getPerimeter());
  }
}
