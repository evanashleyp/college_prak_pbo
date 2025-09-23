package pertemuan4;

public class Cat extends Animal {
  public Cat(String name, int age, String food, gender gender, status status) {
      super(name, age, food, gender, status);
  }

  @Override
  public String printSound() {
      return "Meoww";
  }

  @Override
  public String move() {
      return "Cat " + name + " is walking gracefully.";
  }

  @Override
  public String move(int distance) {
      return "The cat " + name + " jumps for " + distance + " meters.";
  }

  @Override
  public String printData() {
      return "Type: Cat, " + super.printData();
  }
}