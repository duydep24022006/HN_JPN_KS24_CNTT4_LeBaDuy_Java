import java.util.Scanner;

public class bai4 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("Nhập mã ID sách mới (phải > 0): ");
        int id=sc.nextInt();
        while (id<=0){
            System.out.println("Lỗi: ID phải là số dương. Mời nhập lại!");
            System.out.print("Nhập mã ID sách mới (phải > 0): ");
            id=sc.nextInt();
        }
        System.out.printf("Xác nhận: Mã sách %d đã đc ghi nhận",id);
    }
}
