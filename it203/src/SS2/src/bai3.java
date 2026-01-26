import java.util.Scanner;

public class bai3 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Nhập số lượng sách muốn trả: ");
        int n=sc.nextInt();
        int total=0;
        for (int i = 0; i < n; i++) {
            System.out.printf("Nhập số ngày trể của cuốn thứ %d:",(i+1));
            total=total+(sc.nextInt()*5000);
        }
        System.out.printf("===>Tổng tiền phạt: %d VND",total);
    }
}
