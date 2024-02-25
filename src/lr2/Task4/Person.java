package src.lr2.Task4;

enum Gender {
  Male,
  Female
}

public class Person {

  private String name;
  private Gender gender;
  private int age;

  public Person(String name, Gender gender, int age) {
    this.name = name;
    this.gender = gender;
    this.age = age;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public Gender getGender() {
    return this.gender;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getAge() {
    return this.age;
  }

  public static void main(String[] args) {
    Person firstPerson = new Person("John", Gender.Male, 19);

    System.out.println("\nInitial person data");
    System.out.println("Name: " + firstPerson.getName());
    System.out.println("Gender: " + firstPerson.getGender());
    System.out.println("Age: " + firstPerson.getAge());

    firstPerson.setName("Olivia");
    firstPerson.setAge(35);
    firstPerson.setGender(Gender.Female);

    System.out.println("\nUpdated person data");
    System.out.println("Name: " + firstPerson.getName());
    System.out.println("Gender: " + firstPerson.getGender());
    System.out.println("Age: " + firstPerson.getAge());
  }
}
