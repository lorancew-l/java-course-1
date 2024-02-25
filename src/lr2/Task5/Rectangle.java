package src.lr2.Task5;

public class Rectangle {
  private double width;
  private double length;

  public Rectangle(double width, double length) {
    this.width = width;
    this.length = length;
  }

  public void setWidth(double width) {
    this.width = width;
  }

  public double getWidth() {
    return this.width;
  }

  public void setLength(double length) {
    this.length = length;
  }

  public double getLength() {
    return this.length;
  }

  public double getArea() {
    return this.width * this.length;
  }

  public double getPerimeter() {
    return (width + length) * 2;
  }

  public static void main(String[] args) {
    Rectangle rectangle = new Rectangle(5.0f, 2.0f);
    System.out.println("Width: " + rectangle.getWidth());
    System.out.println("Length: " + rectangle.getLength());
    System.out.println("Area: " + rectangle.getArea());
    System.out.println("Perimeter: " + rectangle.getPerimeter());
  }
}
