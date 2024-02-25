package src.lr2.Task6;

interface IShape {
  double getArea();

  double getPerimeter();
}

class Circle implements IShape {
  private double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  @Override
  public double getArea() {
    return Math.PI * Math.pow(this.radius, 2);
  }

  @Override
  public double getPerimeter() {
    return 2 * Math.PI * this.radius;
  }
}

class Square implements IShape {
  private double side;

  public Square(double side) {
    this.side = side;
  }

  @Override
  public double getArea() {
    return Math.pow(this.side, 2);
  }

  @Override
  public double getPerimeter() {
    return 4 * this.side;
  }
}

class Triangle implements IShape {
  private double a, b, c;

  public Triangle(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  @Override
  public double getArea() {
    double s = (this.a + this.b + this.c) / 2;
    return Math.sqrt(s * (s - this.a) * (s - this.b) * (s - this.c));
  }

  @Override
  public double getPerimeter() {
    return this.a + this.b + this.c;
  }
}
