import java.util.Scanner;

public  class bai2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Nhập số ngày chậm trễ: ");
        int lateDays= sc.nextInt();

        System.out.print("Nhập số lượng sách mượn: ");
        int borrowedBooks=sc.nextInt();

        double Total = lateDays *  borrowedBooks * 5000;
        System.out.println("Tiền phạt gốc: " +Total);

        double adjustedFine;
        if(lateDays>7&&borrowedBooks>=3){
            adjustedFine=Total+(Total*0.2);
        }else{
            adjustedFine=Total;
        }
        System.out.println("Tiền phạt sau điều chỉnh: " +adjustedFine);
        boolean lockCard=(adjustedFine-Total)>50000;
        System.out.println("Yêu cầu khóa thẻ: "+(lockCard?"true":"false"));

    }
}