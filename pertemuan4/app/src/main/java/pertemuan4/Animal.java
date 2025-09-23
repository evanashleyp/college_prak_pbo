package pertemuan4;

public abstract class Animal {
    protected String name;
    protected int age;
    protected String food;
    protected gender gender;
    protected status status;

    public Animal(String name, int age, String food, gender gender, status status) {
        this.name = name;
        this.age = age;
        this.food = food;
        this.gender = gender;
        this.status = status;
    }

    public abstract String printSound();
    public abstract String move();
    
    public String move(int distance) {
        return name + " moves for " + distance + " meters.";
    }

    public boolean isAlive() {
        return status == status.ALIVE;
    }

    public String printData() {
        return "Name: " + name + ", Age: " + age + ", Food: " + food +
            ", gender: " + gender + ", Status: " + status;
    }
}