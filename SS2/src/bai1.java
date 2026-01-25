import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập tuổi của bạn: ");
        int age=sc.nextInt();
        System.out.print("Nhập số sách đang muốn: ");
        int n=sc.nextInt();
        System.out.printf("Kết quả: %s",age>=18&&n<=3?"Bạn đủ điều kiện mượn sách quý hiếm":"Không đủ điều kiện");
        if(age>=18&&n<=3){
            return;
        }else if(age<18){
            System.out.println("\nLý do: Bạn phải từ 18 tuổi đổ lên.");
        }else{
            System.out.println("\nLý do: Bạn đã mượn tối đa 3 cuốn.");
        }
    }
}
