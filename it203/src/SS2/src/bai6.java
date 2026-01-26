import java.util.Scanner;

public class bai6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int n,sum = 0;
        for (int i = 2; i < 9; i++) {
            String day = (i == 8) ? "Chủ nhật" : "ngày thứ " + i;
            System.out.print("Nhập lượt mượn " + day + ": ");
            n= sc.nextInt();
            if(max<n) max=n;
            if(min>n)min=n;
            sum+=n;
        }
        double avg = sum / 7.0;
        System.out.println("--- KẾT QUẢ THỐNG KÊ ---");
        System.out.println("Lượt mượn cao nhất: "+max);
        System.out.println("Lượt mượn ít nhất: "+min);
        System.out.printf("Trung bình lượt mượn/ngày: %.2f\n",avg);
    }
}
