package pertemuan4;

class Horse extends Animal {
  public Horse(String name, int age, String food, gender gender, status status) {
      super(name, age, food, gender, status);
  }

  @Override
  public String printSound() {
      return "Neighhh";
  }

  @Override
  public String move() {
      return "Horse " + name + " is galloping.";
  }

  @Override
  public String move(int distance) {
      return "The horse " + name + " gallops for " + distance + " meters.";
  }

  @Override
  public String printData() {
      return "Type: Horse, " + super.printData();
  }
}