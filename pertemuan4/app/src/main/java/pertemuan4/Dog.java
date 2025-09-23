package pertemuan4;

public class Dog extends Animal {
  public Dog(String name, int age, String food, gender gender, status status) {
      super(name, age, food, gender, status);
  }

  @Override
  public String printSound() {
      return "Woof Woof";
  }

  @Override
  public String move() {
      return "Dog " + name + " is running.";
  }

  @Override
  public String move(int distance) {
      return "The dog " + name + " runs for " + distance + " meters.";
  }

  @Override
  public String printData() {
      return "Type: Dog, " + super.printData();
  }
} 
