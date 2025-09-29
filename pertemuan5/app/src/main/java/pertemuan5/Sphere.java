package pertemuan5;

public class Sphere extends ThreeDObject {
  protected Double radius;

  public Sphere() {
    System.out.println("radius default set to 1.00");
    this.radius = 1.00;
    this.name = name.SPHERE;
    calculate();
  }

  public Sphere(Double r) {
    this.radius = r;
    this.name = name.SPHERE;
    calculate();
  }

  @Override
  public void calculate() {
    this.area = PI * radius * radius * 4;
    this.volume = radius * radius * radius * 4 / 3 * PI;
  }
}
