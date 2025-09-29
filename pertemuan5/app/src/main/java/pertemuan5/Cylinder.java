package pertemuan5;

public class Cylinder extends ThreeDObject {
  protected Double radius;
  protected Double height;

  public Cylinder() {
    System.out.println("radius and height set to 1.00");
    this.radius = 1.00;
    this.height = 1.00;
    this.name = name.CYLINDER;
    calculate();
  }

  public Cylinder(Double r, Double h) {
    this.radius = r;
    this.height = h;
    this.name = name.CYLINDER;
    calculate();
  }

  @Override
  public void calculate() {
    this.area = PI * 2 * radius * (radius + height);
    this.volume = height * radius * radius * PI;
  }
}
