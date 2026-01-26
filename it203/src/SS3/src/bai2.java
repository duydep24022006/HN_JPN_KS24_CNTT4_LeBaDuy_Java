import java.util.Scanner;

public class bai2 {
    public static int searchBooks(String[] arr, String search){

        int flag=-1;
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i].equalsIgnoreCase(search)){
                flag=i;
                break;
            }
        }
        return flag;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[]arrBooks={"doremon","conan","phép thuật win","baby shark","cô giáo thảo"};
        System.out.print("Nhập tên sách cần tìm: ");
        String nameBook=sc.nextLine();
        int index=searchBooks(arrBooks,nameBook);
        if(index!=-1){
            System.out.printf("Tìm thấy sách '%s' tại vị trí: %d\n",nameBook,index);
        }else{
            System.out.println("Sách không tồn tại trong thư viện");
        }
    }
}
