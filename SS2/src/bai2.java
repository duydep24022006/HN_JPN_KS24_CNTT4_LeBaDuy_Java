
import java.util.Scanner;

public class bai2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Nhập mã khu vực (A,B,C,D): ");
        String n=sc.nextLine();
        n=n.toUpperCase();
        switch(n){
            case "A":
                System.out.println("Tầng 1: Sách Văn học");
                break;
            case "B":
                System.out.println("Tầng 2: Sách Khoa học");

                break;
            case "C":
                System.out.println("Tầng 3: Sách Ngoại ngữ");

                break;
            case "D":
                System.out.println("Tầng 4: Sách Tin học");
                break;
            default:
                System.out.println(" nhập sai mã");
        }
    }
}