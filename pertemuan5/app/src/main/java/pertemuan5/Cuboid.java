package pertemuan5;

public class Cuboid extends ThreeDObject {
  protected Double width;
  protected Double height;
  protected Double length;

  public Cuboid() {
    System.out.println("width height and length set to 1.00");
    this.width = 1.00;
    this.height = 1.00;
    this.length = 1.00;
    this.name = name.CUBOID;
    calculate();
  }

  public Cuboid(Double w, Double h, Double l) {
    this.width = w;
    this.height = h;
    this.length = l;
    this.name = name.CUBOID;
    calculate();
  }

  @Override
  public void calculate() {
    this.area = 2 * (length * width + width * height + length * height);
    this.volume = height * length * width;
  }
}
