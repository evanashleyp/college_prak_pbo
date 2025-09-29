package pertemuan5;

public class Cube extends ThreeDObject {
  protected Double side;

  public Cube() {
    System.out.println("side length set to 1.00");
    this.side = 1.00;
    this.name = name.CUBE;
    calculate();
  }

  public Cube(Double s) {
    this.side = s;
    this.name = name.CUBE;
    calculate();
  }
  @Override
  public void calculate() {
    this.area = 6 * side * side;
    this.volume = side * side * side;
  }
}
