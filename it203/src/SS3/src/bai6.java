import java.util.Arrays;public class bai6 {

    // gộp 2 mảng tăng dần + lọc trùng
    public static int[] mergeBooks(int[] a, int[] b) {
        int i = 0, j = 0;
        int[] temp = new int[a.length + b.length];
        int k = 0;

        while (i < a.length && j < b.length) {
            int val;
            if (a[i] < b[j]) {
                val = a[i++];
            } else if (a[i] > b[j]) {
                val = b[j++];
            } else {
                val = a[i];
                i++;
                j++;
            }

            // lọc trùng trong mảng kết quả
            if (k == 0 || temp[k - 1] != val) {
                temp[k++] = val;
            }
        }

        // xử lý phần còn lại của a
        while (i < a.length) {
            int val = a[i++];
            if (k == 0 || temp[k - 1] != val) {
                temp[k++] = val;
            }
        }

        while (j < b.length) {
            int val = b[j++];
            if (k == 0 || temp[k - 1] != val) {
                temp[k++] = val;
            }
        }

        return Arrays.copyOf(temp, k);
    }

    public static void main(String[] args) {
        int[] arrayFirst  = {1, 3, 5, 7, 9};
        int[] arraySecond = {2, 3, 5, 6, 8, 9, 10};

        int[] arrayMerge = mergeBooks(arrayFirst, arraySecond);

        System.out.println("Kho cũ:  " + Arrays.toString(arrayFirst));
        System.out.println("Lô mới:  " + Arrays.toString(arraySecond));
        System.out.println("Kho tổng (đã gộp & lọc trùng): " + Arrays.toString(arrayMerge));
    }
}