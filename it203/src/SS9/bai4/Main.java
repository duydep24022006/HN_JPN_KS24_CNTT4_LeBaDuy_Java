package SS9.bai4;

public class Main {
    public static void main(String[] args) {

        // declared type: Animal
        // actual type: Dog
        Animal animal = new Dog();

        // gọi phương thức chung: ok (đa hình runtime -> gọi sound() của Dog)
        animal.sound();

        //  không gọi được phương thức riêng của Dog vì kiểu khai báo là Animal
        // animal.guardHouse();

        //  downcasting an toàn
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal; // ép kiểu
            dog.guardHouse();       // gọi method riêng
        } else {
            System.out.println("animal is not a dog");
        }
    }
}

