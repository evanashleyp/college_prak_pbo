package pertemuan4;

public class Duck extends Animal {
  public Duck(String name, int age, String food, gender gender, status status) {
      super(name, age, food, gender, status);
  }

  @Override
  public String printSound() {
      return "Quack Quack";
  }

  @Override
  public String move() {
      return "Duck " + name + " is swimming.";
  }

  @Override
  public String move(int distance) {
      return "The duck " + name + " swims for " + distance + " meters.";
  }

  @Override
  public String printData() {
      return "Type: Duck, " + super.printData();
  }
}
