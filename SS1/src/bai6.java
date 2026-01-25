import java.util.Scanner;

public class bai6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập số thứ tự của sách trong hệ thống: ");
        int stt=sc.nextInt();
        if (stt<=0){
            System.out.println("Không đc nhập giá trị nhỏ hơn 1");
            return;
        }
        System.out.println("\n--- THÔNG TIN ĐỊNH VỊ ---");
        System.out.println("Sách số: "+stt);
        int x= stt/25+1;

        int y=stt%x+1;
        String z=x>10?"Khu Viễn (Xa Cửa)":"Khu Cận(Gần Cửa)";
        System.out.printf("Địa chỉ: Kệ %d - Vị trí %d\n",x,y);
        System.out.println("Phân khu: "+z);
    }
}