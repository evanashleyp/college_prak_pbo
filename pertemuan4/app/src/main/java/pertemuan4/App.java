package pertemuan4;
enum status { DEAD, ALIVE }
enum gender { MALE, FEMALE }

public class App {
    public static void main(String[] args) {
        Animal cat = new Cat("Mimi", 2, "Fish", gender.FEMALE, status.ALIVE);
        Animal dog = new Dog("Max", 3, "Meat", gender.MALE, status.ALIVE);
        Animal duck = new Duck("Stacy", 1, "Grain", gender.FEMALE, status.ALIVE);
        Animal horse = new Horse("Spirit", 5, "Grass", gender.MALE, status.DEAD);

        Animal[] animals = { cat, dog, duck, horse };

        for (Animal a : animals) {
            System.out.println(a.printData());
            System.out.println("Sound: " + a.printSound());
            System.out.println("Move: " + a.move(5));
            System.out.println("Alive? " + a.isAlive());
            System.out.println();
        }
    }
}
