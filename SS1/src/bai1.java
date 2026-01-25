
import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.print("Nhập mã sách: ");
        String bookID= sc.nextLine();

        System.out.print("Nhập tên sách: ");
        String bookName=sc.nextLine();

        System.out.print("Nhập năm xuất bản: ");
        int publishYear=sc.nextInt();

        System.out.print("Nhập giá bìa: ");
        double price= sc.nextDouble();

        System.out.print("Sách còn trong kho(true/false): ");
        boolean isAvailable=sc.nextBoolean();

        System.out.println("\n--- PHIẾU THÔNG TIN SÁCH ---");
        System.out.println("Tên sách: " + bookName.toUpperCase());
        System.out.println("Mã số: " + bookID + " | Tuổi thọ: " + (2026-publishYear) + " năm");
        System.out.printf("Giá bán: %.2f VNĐ\n", price);
        System.out.println("Tình trạng: " + (isAvailable?"Còn sách":"Hết sách"));

    }
}