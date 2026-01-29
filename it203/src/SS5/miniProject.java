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
                    twoSum();
                    break;
                case 2:
                    moveZeroes();
                    break;
                case 3:
                    validPalindrome();
                    break;
                case 4:
                    reverseWords();
                    break;
                case 5:
                    happyNumber();
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
        System.out.println("0. Thoát");
        System.out.println("----------------------------------------");
    }

    static int readInteger(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("vui lòng nhập số.");
            }
        }
    }

    // ================= CASE 1 =================
    static void twoSum() {
        System.out.print("nhập mảng (vd: 1 2 3 4): ");
        String line = sc.nextLine().trim();
        if (line.isEmpty()) line = "2 7 11 15";

        String[] parts = line.split("\\s+");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

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

        System.out.println(Arrays.toString(arr));
        if (iFound == -1) {
            System.out.println("không tìm thấy.");
        } else {
            System.out.println("i = " + iFound + ", j = " + jFound);
        }
    }

    // ================= CASE 2 =================
    static void moveZeroes() {
        System.out.print("nhập mảng (vd: 1 0 3 0 4): ");
        String line = sc.nextLine().trim();
        if (line.isEmpty()) line = "0 1 0 3 12";

        String[] parts = line.split("\\s+");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        int pos = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int tmp = arr[pos];
                arr[pos] = arr[i];
                arr[i] = tmp;
                pos++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    // ================= CASE 3 =================
    static void validPalindrome() {
        System.out.print("nhập chuỗi: ");
        String input = sc.nextLine();

        if (input.trim().isEmpty()) {
            System.out.println(false);
            return;
        }

        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0, right = cleaned.length() - 1;
        boolean ok = true;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                ok = false;
                break;
            }
            left++;
            right--;
        }

        System.out.println(ok);
    }

    // ================= CASE 4 =================
    static void reverseWords() {
        System.out.print("nhập chuỗi: ");
        String s = sc.nextLine();
        if (s.trim().isEmpty()) s = "  world   hello  ";

        String[] words = s.trim().split("\\s+");
        String result = "";

        for (int i = words.length - 1; i >= 0; i--) {
            result += words[i];
            if (i != 0) result += " ";
        }

        System.out.println(result);
    }

    // ================= CASE 5 =================
    static void happyNumber() {
        int n = readInteger("nhập n = ");
        if (n <= 0) {
            System.out.println(false);
            return;
        }

        int cur = n;
        while (cur != 1 && cur != 4) {
            int sum = 0;
            while (cur > 0) {
                int d = cur % 10;
                sum += d * d;
                cur /= 10;
            }
            cur = sum;
        }

        System.out.println(cur == 1);
    }
}
