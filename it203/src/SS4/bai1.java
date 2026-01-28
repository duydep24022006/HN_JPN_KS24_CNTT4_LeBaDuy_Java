package SS4;

import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Mời bạn nhập vào tên sách: ");
        String title=sc.nextLine().trim().replaceAll("\\s+", " ");
        System.out.print("Mời bạn nhập vào tên tác giả: ");
        String author=sc.nextLine().toUpperCase().trim().replaceAll("\\s+", " ");
        System.out.printf("[%s] - Tác giả: %s",title,author);
    }
}
