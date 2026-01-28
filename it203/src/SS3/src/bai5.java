package SS3.src;
import java.util.Scanner;

public class bai5 {

    public static int deleteBook(int[] arr, int n, int bookId) {
        int index = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == bookId) {
                index = i;
                break;
            }
        }

        if (index == -1) return n;

        for (int i = index; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[n - 1] = 0;
        return n - 1;
    }

    public static void renderArr(int[] arr, int n) {
        System.out.printf("kho sách hiện tại (%d cuốn): [", n);
        for (int i = 0; i < n; i++) {
            if (i == n - 1) System.out.print(arr[i]);
            else System.out.print(arr[i] + ", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] books = {12, 5, 99, 34, 7, 60, 18, 41, 3, 75};
        int booksLength = books.length;

        while (true) {
            renderArr(books, booksLength);

            System.out.print("nhập mã sách cần xóa (0 để thoát): ");
            int bookId = sc.nextInt();
            if (bookId == 0) return;

            int oldLength = booksLength;
            booksLength = deleteBook(books, booksLength, bookId);

            if (booksLength == oldLength) {
                System.out.println("mã ko tồn tại");
            } else {
                System.out.println("đã xóa sách mã " + bookId);
            }
        }
    }
}
