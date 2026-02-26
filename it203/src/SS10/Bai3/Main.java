package SS10.Bai3;

public class Main {
    public static void main(String[] args) {

        Duck duck = new Duck("Vịt Trắng");
        Fish fish = new Fish("Cá Vàng");

        duck.swim();
        duck.fly();

        fish.swim();
        // fish.fly(); ❌ lỗi – Cá không biết bay
    }
}
