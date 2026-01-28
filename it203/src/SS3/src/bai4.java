package SS3.src;
public class bai4 {
    public static int[]  sortBooks(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
    public static void  displayBooks(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {

            System.out.printf("%s %d",i>0?",":"",arr[i]);
        }
        System.out.println("]");

    }
    public static void main(String[] args) {
        int[] arr = {12, 5, 99, 34, 7, 60, 18, 41, 3, 75};
        System.out.print("Trước khi sắp xếp:");
        displayBooks(arr);

        arr= sortBooks(arr);

        System.out.print("Sau khi sắp xếp:");
        displayBooks(arr);
    }
}
