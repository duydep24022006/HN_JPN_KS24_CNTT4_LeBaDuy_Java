import java.util.Scanner;

public class bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập giá sách (USD - kiểu double): ");
        double usd = sc.nextDouble();

        System.out.print("Nhập tỷ giá (float): ");
        float rate = sc.nextFloat();

        double vndExact = usd * rate;
        long vndRound = (long) vndExact;

        System.out.println("Giá chính xác (số thực): " + vndExact);
        System.out.println("Giá làm tròn để thanh toán (long): " + vndRound);
    }
}