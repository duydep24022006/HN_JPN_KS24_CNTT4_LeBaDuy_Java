package SS11.Thuc_Hanh;

public class Main {
    public static void main(String[] args) {

        Drink[] drinks = new Drink[3];

        drinks[0] = new Coffee("C01", "Bac siu", 30000, true);
        drinks[1] = new FruitJuice("F01", "Nuoc cam", 40000, 10);
        drinks[2] = null;

        for (int i = 0; i < drinks.length; i++) {

            if (drinks[i] != null) {

                drinks[i].displayInfo();

                System.out.println("Thanh tien: " + drinks[i].calculatePrice());

                // kiểm tra nếu object có implements IMixable
                if (drinks[i] instanceof IMixable) {
                    IMixable m = (IMixable) drinks[i];
                    m.mix();
                }

                System.out.println("-------------------");
            }
        }
    }
}
