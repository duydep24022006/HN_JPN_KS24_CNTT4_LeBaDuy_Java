package SS9.bai4;

public class Dog extends Animal {

    @Override
    public void sound() {
        System.out.println("dog barks: woof woof");
    }

    public void guardHouse() {
        System.out.println("dog is guarding the house");
    }
}
