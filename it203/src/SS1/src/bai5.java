import java.util.Scanner;

public class bai5 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int n;

        while (true) {
            System.out.print("Nhập mã sách(4 chữ Số): ");
            n = sc.nextInt();

            n = Math.abs(n);

            if (n >= 1000 && n <= 9999) {
                break;
            } else {
                System.out.println("Sai! Bạn phải nhập đúng 4 chữ số (1000 -> 9999). Nhập lại!");
            }
        }
        int thousands=n/1000;
        int hundreds=(n/100)%10;
        int dozens=(n/10)%10;
        int units=n%10;
        int sumOfFirstThreeNumber = thousands + hundreds + dozens;
        System.out.println("Chữ số kiểm tra kì vọng: "+sumOfFirstThreeNumber);
        boolean isUnits=units==sumOfFirstThreeNumber;
        System.out.println("Kết quả kiểm tra mã sách: "+(isUnits?"Hợp lệ":"Sai mã"));

    }
}