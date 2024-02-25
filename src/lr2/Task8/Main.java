package src.lr2.Task8;

public class Main {
  public static void main(String[] args) {
    System.out.println("\nAnimals");

    Dog dog = new Dog("Sally", 2, "Labrador", "Meat");
    Cat cat = new Cat("Alma", 3, "Abyssinian", "Fish");
    Bird bird = new Bird("Ruke", 5, "Parrot", true);

    System.out.println("Dog");
    System.out.println("Name: " + dog.getName());
    System.out.println("Age: " + dog.getAge());
    System.out.println("Food: " + dog.getFoodType());
    dog.makeSound();

    System.out.println("\nCat");
    System.out.println("Name: " + cat.getName());
    System.out.println("Age: " + cat.getAge());
    System.out.println("Food: " + cat.getFoodType());
    cat.makeSound();

    System.out.println("\nBird");
    System.out.println("Name: " + bird.getName());
    System.out.println("Age: " + bird.getAge());
    System.out.println("Can fly: " + bird.canFly());
    bird.makeSound();

    Square square = new Square(2);
    Rhombus rhombus = new Rhombus(4, 30);
    Parallelogram parallelogram = new Parallelogram(3, 4, 30);

    System.out.println("\nSquare");
    System.out.println("Width: " + square.getWidth());
    System.out.println("Length: " + square.getLength());
    System.out.println("Perimeter: " + square.getPerimeter());
    System.out.println("Area: " + square.getArea());

    System.out.println("\nRhombus");
    System.out.println("Width: " + rhombus.getWidth());
    System.out.println("Length: " + rhombus.getLength());
    System.out.println("Angle: " + parallelogram.getAngle());
    System.out.println("Perimeter: " + rhombus.getPerimeter());
    System.out.println("Area: " + rhombus.getArea());

    System.out.println("\nParallelogram");
    System.out.println("Width: " + parallelogram.getWidth());
    System.out.println("Length: " + parallelogram.getLength());
    System.out.println("Angle: " + parallelogram.getAngle());
    System.out.println("Perimeter: " + parallelogram.getPerimeter());
    System.out.println("Area: " + parallelogram.getArea());
  }
}
