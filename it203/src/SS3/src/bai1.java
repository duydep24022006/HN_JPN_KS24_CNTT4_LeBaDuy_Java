import java.util.Scanner;

public class bai1 {

    public static  int[] addBookToLibraries(int n){
        Scanner sc = new Scanner(System.in);
        int[]arr=new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("\nSách thứ %d: ",(i+1));
            arr[i]= sc.nextInt();
        }
        return arr;
    }
    public static  void  displayLibraries(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(",\t %d",arr[i]);
        }

    }
    public static void main(String[] args) {
        System.out.print("Nhập số lượng sách cần quản lý: ");
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        System.out.printf("Nhập mã số cho %d cuốn sách\n",n);
        int[]arr=addBookToLibraries(n);
        System.out.println("--- KẾT QUẢ ---");
        System.out.print("Danh sách mã sách: ");
        displayLibraries(arr);

    }
}