package SS7.Bai4;

public class main {
    public static void main(String[] args) {
        ClassRoom sv1 = new ClassRoom("An");
        ClassRoom sv2 = new ClassRoom("Bình");
        ClassRoom sv3 = new ClassRoom("Cường");

        sv1.payToFund(100_000);
        sv2.payToFund(150_000);
        sv3.payToFund(200_000);

        System.out.println("Tổng quỹ lớp: " + ClassRoom.getClassFund());
    }
}
