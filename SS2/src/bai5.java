import java.util.Scanner;

public class bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=0,m=0;
        int spoint=100;
        System.out.println("--- HỆ THỐNG ĐÁNH GIÁ ĐỘC GIẢ ---");
        System.out.println("(Nhập số ngày trễ. Nhập 999 để kết thúc)");

        while(true){
            System.out.print("Số ngày trễ của lần này: ");
            n=sc.nextInt();
            if (n==999){
                break;
            }
            System.out.printf("Trả trễ %d ngày: %d điểm \n",n,n>=0?(n*-2):(m=5));
            spoint+=(n*-2)+m;
            m=0;
        };
        System.out.println("Tổng điểm uy tín: "+ spoint);
        System.out.print("Xếp loại: ");
        if(spoint>120){
            System.out.println("Độc giả Thân thiết");
        }else if(spoint<120&&spoint>80){
            System.out.println("Độc giả Tiêu chuẩn");
        }else{
            System.out.println("Độc giả cần lưu ý");
        }
    }
}
