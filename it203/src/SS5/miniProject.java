package SS5;

import java.util.Arrays;
import java.util.Scanner;

public class miniProject {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = readInteger("chọn chức năng: ");
            switch (choice) {
                case 1:
                    runTwoSum();
                    break;
                case 2:
                    runMoveZeroes();
                    break;
                case 3:
                    runValidPalindrome();
                    break;
                case 4:
                    runReverseWords();
                    break;
                case 5:
                    runHappyNumber();
                    break;
                case 0:
                    System.out.println("thoát chương trình.");
                    break;
                default:
                    System.out.println("lựa chọn không hợp lệ.");
            }

        } while (choice != 0);
        sc.close();
    }

    static void showMenu() {
        System.out.println("========================================");
        System.out.println("                 MENU ");
        System.out.println("========================================");
        System.out.println("1. Tìm cặp số có tổng bằng K (Two Sum)");
        System.out.println("2. Dồn số 0 về cuối (Move Zeroes)");
        System.out.println("3. Kiểm tra chuỗi đối xứng (Valid Palindrome)");
        System.out.println("4. Đảo ngược từ trong câu (Reverse Words)");
        System.out.println("5. Số hạnh phúc (Happy Number)");
        System.out.println("0. thoát");
        System.out.println("----------------------------------------");
    }

    static int readInteger(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (Exception e) {
                System.out.println("vui lòng nhập số.");
            }
        }
    }

    static int[] readIntArray() {
        System.out.println("nhập mảng số nguyên (vd: 1 2 3 0 4 hoặc 1,2,3,0,4). để trống dùng mẫu.");
        System.out.print("arr = ");
        String line = sc.nextLine().trim();
        if (line.isEmpty()) return new int[]{2, 7, 11, 15, 0, 3, 0, 4};
        line = line.replaceAll(",", " ");
        String[] parts = line.split("\\s+");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        return arr;
    }

    static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    static void runTwoSum() {
        int[] arr = readIntArray();
        int target = readInteger("nhập target = ");
        int iFound = -1, jFound = -1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    iFound = i;
                    jFound = j;
                    break;
                }
            }
            if (iFound != -1) break;
        }
        printArray(arr);
        if (iFound == -1) {
            System.out.println("không tìm thấy.");
        } else {
            System.out.println("i = " + iFound + ", j = " + jFound);
        }
    }

    static void runMoveZeroes() {
        int[] arr = readIntArray();
        printArray(arr);
        int pos = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int tmp = arr[pos];
                arr[pos] = arr[i];
                arr[i] = tmp;
                pos++;
            }
        }
        printArray(arr);
    }

    static void runValidPalindrome() {
        System.out.print("nhập chuỗi: ");
        String input = sc.nextLine();

        if (input.trim().isEmpty()) {
            System.out.println("false");
            return;
        }

        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = cleaned.length() - 1;

        boolean isPalindrome = true;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        System.out.println(isPalindrome);
    }


    static void runReverseWords() {
        System.out.print("nhập chuỗi: ");
        String s = sc.nextLine();
        if (s.trim().isEmpty()) s = "  world   hello  ";
        String trimmed = s.trim();
        if (trimmed.isEmpty()) {
            System.out.println("");
            return;
        }
        String[] words = trimmed.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) sb.append(" ");
        }
        System.out.println(sb.toString());
    }

    static void runHappyNumber() {
        int n = readInteger("nhập n = ");
        if (n <= 0) {
            System.out.println("false");
            return;
        }
        int cur = n;
        while (cur != 1 && cur != 4) {
            cur = sumSquareDigits(cur);
        }
        System.out.println(cur == 1);
    }

    static int sumSquareDigits(int x) {
        int sum = 0;
        while (x > 0) {
            int d = x % 10;
            sum += d * d;
            x /= 10;
        }
        return sum;
    }
}
