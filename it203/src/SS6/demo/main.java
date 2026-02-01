package SS6.demo;

public class main {
    public static void main(String[] args) {
        book b1=new book("B01", "lập trình java", 120000);
        book b2 = new book();
        b2.setId("B02");
        b2.setTitle("cơ sở dữ liệu");
        b2.setPrice(150000);

        System.out.println("=== thông tin sách 1 ===");
        b1.display();

        System.out.println("\n=== thông tin sách 2 ===");
        b2.display();
    }
}
