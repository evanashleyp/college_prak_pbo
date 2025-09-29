package pertemuan5;

public abstract class ThreeDObject {
  public static final Double PI = 3.14159;
  protected Double volume;
  protected Double area;
  protected name name;

  protected ThreeDObject(){
    System.out.println("Object Created");
  }

  public name getName() {
    return this.name;
  }

  public String getScript() {
    return "Name : " + getName() + ", Volume = " + volume + ", Area = " + area;
  }

  public Double getVolume() {
    return this.volume;
  }
  public Double getSurfaceArea() {
    return this.area;
  }

  public abstract void calculate();
}
