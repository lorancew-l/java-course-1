package src.lr7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Dog implements Serializable {
  private String name;
  private int age;
  private String breed;
  private String foodType;

  public Dog(String name, int age, String breed, String foodType) {
    this.name = name;
    this.age = age;
    this.breed = breed;
    this.foodType = foodType;
  }

  public String getName() {
    return this.name;
  }

  public int getAge() {
    return this.age;
  }

  public String getBreed() {
    return this.breed;
  }

  public String getFoodType() {
    return this.foodType;
  }
}

public class Task8 {
  public static void main(String[] args) {
    Dog obj = new Dog("Sally", 2, "Labrador", "Meat");

    String filename = "src/lr7/dog.ser";

    try {
      FileOutputStream fileOut = new FileOutputStream(filename);
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(obj);
      out.close();
      fileOut.close();
      System.out.println("Объект успешно записан в файл: " + filename);
    } catch (IOException e) {
      System.out.println("Ошибка при записи объекта в файл: " + e.getMessage());
    }

    Dog restoredDog = null;
    try {
      FileInputStream fileIn = new FileInputStream(filename);
      ObjectInputStream in = new ObjectInputStream(fileIn);
      restoredDog = (Dog) in.readObject();
      in.close();
      fileIn.close();
      System.out.println("Объект успешно восстановлен из файла: " + filename);
    } catch (IOException | ClassNotFoundException e) {
      System.out.println("Ошибка при восстановлении объекта из файла: " + e.getMessage());
    }

    if (restoredDog != null) {
      System.out.println("Восстановленные значения полей:");
      System.out.println("Name: " + restoredDog.getName());
      System.out.println("Age: " + restoredDog.getAge());
      System.out.println("Breed: " + restoredDog.getBreed());
      System.out.println("FoodType: " + restoredDog.getFoodType());
    }

    if (new File(filename).delete()) {
      System.out.println("Файл удален: " + filename);
    } else {
      System.out.println("Не удалось удалить файл: " + filename);
    }
  }
}