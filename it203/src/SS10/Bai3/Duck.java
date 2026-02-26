package SS10.Bai3;

class Duck extends Animal implements Swimmable, Flyable {

    public Duck(String name) {
        super(name);
    }

    @Override
    public void swim() {
        System.out.println(name + " đang bơi dưới nước");
    }

    @Override
    public void fly() {
        System.out.println(name + " đang bay trên trời");
    }
}