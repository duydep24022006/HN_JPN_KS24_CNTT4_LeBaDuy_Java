package SS14.Bai4;

public class Main {
    public static void main(String[] args) {

        Animal animal = new Dog();

        animal.sound();

        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.wagTail();
        }

        Animal animal2 = new Cat();
        animal2.sound();

    }
}
