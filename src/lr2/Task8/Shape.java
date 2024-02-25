package src.lr2.Task8;

abstract class ParallelogramShape {
  protected double width, length;

  public ParallelogramShape(double width, double length) {
    this.width = width;
    this.length = length;
  }

  public double getWidth() {
    return this.width;
  }

  public double getLength() {
    return this.length;
  }

  public abstract double getArea();

  public double getPerimeter() {
    return (this.width + this.length) * 2;
  }
}

class Square extends ParallelogramShape {
  public Square(double side) {
    super(side, side);
  }

  @Override
  public double getArea() {
    return Math.pow(this.width, 2);
  }
}

class Rhombus extends ParallelogramShape {
  private double angle;

  public Rhombus(double side, double angle) {
    super(side, side);
    this.angle = angle;
  }

  public double getAngle() {
    return this.angle;
  }

  @Override
  public double getArea() {
    return Math.pow(this.width, 2) * Math.sin(this.angle * Math.PI / 180);
  }

}

class Rectangle extends ParallelogramShape {
  public Rectangle(double width, double length) {
    super(width, length);
  }

  @Override
  public double getArea() {
    return this.width * this.length;
  }
}

class Parallelogram extends ParallelogramShape {
  private double angle;

  public Parallelogram(double width, double length, double angle) {
    super(width, length);
    this.angle = angle;
  }

  public double getAngle() {
    return this.angle;
  }

  public double getArea() {
    return this.width * this.length * Math.sin(this.angle * Math.PI / 180);
  }

}