package SS5;
import java.util.*;
import java.util.regex.Pattern;

public class miniProject {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            printMenu();
            choice = readInt("chọn chức năng: ");

            switch (choice) {
                case 1:
                    fr1TwoSum();
                    break;
                case 2:
                    fr2MoveZeroes();
                    break;
                case 3:
                    fr3ValidPalindrome();
                    break;
                case 4:
                    fr4ReverseWords();
                    break;
                case 5:
                    fr5HappyNumber();
                    break;
                case 0:
                    System.out.println("thoát chương trình.");
                    break;
                default:
                    System.out.println("lỗi: lựa chọn không hợp lệ, vui lòng chọn 0-5.");
            }

            if (choice != 0) {
                System.out.println("\nnhấn enter để quay lại menu...");
                sc.nextLine();
            }

        } while (choice != 0);

        sc.close();
    }


    static void printMenu() {
        System.out.println("========================================");
        System.out.println("                 MENU ");
        System.out.println("========================================");
        System.out.println("1. [fr1] two sum (tìm cặp tổng bằng k)");
        System.out.println("2. [fr2] move zeroes (dồn số 0 về cuối)");
        System.out.println("3. [fr3] valid palindrome (chuỗi đối xứng + regex)");
        System.out.println("4. [fr4] reverse words (đảo ngược từ trong câu)");
        System.out.println("5. [fr5] happy number (số hạnh phúc)");
        System.out.println("0. thoát");
        System.out.println("----------------------------------------");
    }

    static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("lỗi: vui lòng nhập số nguyên.");
            }
        }
    }

    static int[] readIntArray() {
        System.out.println("nhập mảng số nguyên (vd: 1 2 3 0 4 hoặc 1,2,3,0,4). để trống dùng mẫu.");
        System.out.print("arr = ");
        String line = sc.nextLine().trim();

        if (line.isEmpty()) {
            return new int[]{2, 7, 11, 15, 0, 3, 0, 4};
        }

        line = line.replaceAll(",", " ");
        String[] parts = line.trim().split("\\s+");
        int[] arr = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        return arr;
    }

    static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }


    static void fr1TwoSum() {
        System.out.println("\n[fr1] two sum");
        int[] arr = readIntArray();
        int target = readInt("nhập target = ");

        Map<Integer, Integer> map = new HashMap<>();
        int iFound = -1, jFound = -1;

        for (int i = 0; i < arr.length; i++) {
            int need = target - arr[i];
            if (map.containsKey(need)) {
                iFound = map.get(need);
                jFound = i;
                break;
            }
            map.put(arr[i], i);
        }

        System.out.print("mảng: ");
        printArray(arr);

        if (iFound == -1) {
            System.out.println("không tìm thấy cặp chỉ số thỏa mãn.");
        } else {
            System.out.println("tìm thấy: i = " + iFound + ", j = " + jFound
                    + " (arr[i] + arr[j] = " + arr[iFound] + " + " + arr[jFound] + ")");
        }
    }


    static void fr2MoveZeroes() {
        System.out.println("\n[fr2] move zeroes");
        int[] arr = readIntArray();

        System.out.print("trước: ");
        printArray(arr);

        // two pointers: pos là vị trí đặt số khác 0
        int pos = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int tmp = arr[pos];
                arr[pos] = arr[i];
                arr[i] = tmp;
                pos++;
            }
        }

        System.out.print("sau  : ");
        printArray(arr);
    }


    static void fr3ValidPalindrome() {
        System.out.println("\n[fr3] valid palindrome");
        System.out.println("nhập câu (để trống dùng mẫu: \"A man, a plan, a canal: Panama\").");
        System.out.print("s = ");
        String s = sc.nextLine();

        if (s.trim().isEmpty()) {
            s = "A man, a plan, a canal: Panama";
        }


        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // two pointers kiểm tra đối xứng
        int l = 0, r = cleaned.length() - 1;
        boolean ok = true;
        while (l < r) {
            if (cleaned.charAt(l) != cleaned.charAt(r)) {
                ok = false;
                break;
            }
            l++;
            r--;
        }

        System.out.println("chuỗi gốc   : " + s);
        System.out.println("sau làm sạch: " + cleaned);
        System.out.println("kết quả     : " + ok);
    }


    static void fr4ReverseWords() {
        System.out.println("\n[fr4] reverse words");
        System.out.println("nhập chuỗi (có thể dư khoảng trắng). để trống dùng mẫu: \"  world   hello  \".");
        System.out.print("s = ");
        String s = sc.nextLine();

        if (s.trim().isEmpty()) {
            s = "  world   hello  ";
        }

        String trimmed = s.trim();
        if (trimmed.isEmpty()) {
            System.out.println("chuỗi chỉ có khoảng trắng -> kết quả: \"\"");
            return;
        }

        String[] words = trimmed.split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) sb.append(" ");
        }

        System.out.println("chuỗi gốc : \"" + s + "\"");
        System.out.println("kết quả  : \"" + sb.toString() + "\"");
    }


    static void fr5HappyNumber() {
        System.out.println("\n[fr5] happy number");
        int n = readInt("nhập n (số dương) = ");
        if (n <= 0) {
            System.out.println("lỗi: n phải > 0");
            return;
        }

        Set<Integer> seen = new HashSet<>();
        int cur = n;

        while (cur != 1 && !seen.contains(cur)) {
            seen.add(cur);
            cur = sumSquareDigits(cur);
        }

        System.out.println(n + (cur == 1 ? " là số hạnh phúc (true)" : " không là số hạnh phúc (false)"));
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
