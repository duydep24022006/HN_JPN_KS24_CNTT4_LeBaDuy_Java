package SS11.Thuc_Hanh;

public class Coffee extends Drink {
    private boolean hasMilk;

    public Coffee(String id, String name, double price, boolean hasMilk) {
        super(id, name, price);   // gọi constructor lớp cha
        this.hasMilk = hasMilk;
    }

    @Override
    public double calculatePrice() {
        if (hasMilk == true) {
            return price + 5000;
        } else {
            return price;
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();  // gọi phương thức lớp cha

        if (hasMilk == true) {
            System.out.println("Loai: Co sua");
        } else {
            System.out.println("Loai: Den da");
        }
    }
}
