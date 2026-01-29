package SS5;

import java.util.Scanner;

public class Thuc_Hanh {

    static final int MAX = 100;
    static final String MSSV_REGEX = "^B\\d{7}$"; // B + đúng 7 chữ số

    public static void renderMenu() {
        System.out.println("\n========== MENU QUẢN LÝ MSSV ==========");
        System.out.println("1. Hiển thị danh sách MSSV");
        System.out.println("2. Thêm mới MSSV (Regex)");
        System.out.println("3. Cập nhật MSSV theo vị trí (Regex)");
        System.out.println("4. Xóa MSSV (dồn mảng)");
        System.out.println("5. Tìm kiếm MSSV (không phân biệt hoa thường)");
        System.out.println("6. Thoát");
        System.out.print("Chọn chức năng (1-6): ");
    }

    public static void renderStudents(String[] mssvList, int n) {
        int col1 = 5;
        int col2 = 15;

        String line = "+" + "-".repeat(col1 + 2) + "+" + "-".repeat(col2 + 2) + "+";
        System.out.println(line);
        System.out.printf("| %-" + col1 + "s | %-" + col2 + "s |\n", "STT", "MSSV");
        System.out.println(line);

        if (n <= 0) {
            System.out.printf("| %-" + col1 + "s | %-" + col2 + "s |\n", "-", "(danh sách rỗng)");
            System.out.println(line);
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("| %-" + col1 + "d | %-" + col2 + "s |\n", (i + 1), mssvList[i]);
        }
        System.out.println(line);
    }

    public static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                int x = sc.nextInt();
                sc.nextLine();
                return x;
            }
            System.out.println("lỗi: vui lòng nhập số.");
            sc.nextLine();
        }
    }

    public static String readMssvByRegex(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (s.matches(MSSV_REGEX)) return s;
            System.out.println("mssv không hợp lệ! đúng dạng: B + 7 chữ số (vd: B2101234). nhập lại.");
        }
    }

    public static int createStudent(String[] arr, int n, String student) {
        if (n >= MAX) {
            System.out.println("mảng đã đầy (tối đa 100). không thể thêm.");
            return n;
        }
        arr[n] = student;
        System.out.println("thêm thành công!");
        return n + 1;
    }

    public static void updateStudent(String[] arr, int n, Scanner sc) {
        if (n == 0) {
            System.out.println("danh sách rỗng, không thể cập nhật.");
            return;
        }

        int index = readInt(sc, "nhập index cần sửa (0.." + (n - 1) + "): ");
        if (index < 0 || index >= n) {
            System.out.println("index không hợp lệ.");
            return;
        }

        String newMssv = readMssvByRegex(sc, "nhập MSSV mới: ");
        arr[index] = newMssv;
        System.out.println("cập nhật thành công!");
    }

    public static int findIndexByMssvIgnoreCase(String[] arr, int n, String key) {
        for (int i = 0; i < n; i++) {
            if (arr[i] != null && arr[i].equalsIgnoreCase(key)) return i;
        }
        return -1;
    }

    public static int deleteStudent(String[] arr, int n, Scanner sc) {
        if (n == 0) {
            System.out.println("danh sách rỗng, không thể xóa.");
            return n;
        }

        System.out.print("nhập MSSV cần xóa: ");
        String key = sc.nextLine().trim();

        int idx = findIndexByMssvIgnoreCase(arr, n, key);
        if (idx == -1) {
            System.out.println("không tìm thấy MSSV: " + key);
            return n;
        }

        for (int i = idx; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[n - 1] = null;
        System.out.println("xóa thành công!");
        return n - 1;
    }

    public static void searchStudents(String[] arr, int n, Scanner sc) {
        if (n == 0) {
            System.out.println("danh sách rỗng.");
            return;
        }

        System.out.print("nhập chuỗi cần tìm: ");
        String keyword = sc.nextLine().trim().toLowerCase();

        if (keyword.isEmpty()) {
            System.out.println("chuỗi tìm kiếm không được để trống.");
            return;
        }

        int found = 0;
        System.out.println("\nkết quả tìm kiếm:");
        for (int i = 0; i < n; i++) {
            if (arr[i] != null && arr[i].toLowerCase().contains(keyword)) {
                System.out.println("- index " + i + ": " + arr[i]);
                found++;
            }
        }

        if (found == 0) {
            System.out.println("không có MSSV nào chứa \"" + keyword + "\"");
        } else {
            System.out.println("tổng найден: " + found);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] students = new String[MAX];
        int n = 0;

        while (true) {
            renderMenu();

            int choice;
            while (!sc.hasNextInt()) {
                System.out.print("vui lòng nhập số 1-6: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    renderStudents(students, n);
                    break;

                case 2: {
                    String newMssv = readMssvByRegex(sc, "mời bạn nhập MSSV mới: ");
                    n = createStudent(students, n, newMssv);
                    break;
                }

                case 3:
                    updateStudent(students, n, sc);
                    break;

                case 4:
                    n = deleteStudent(students, n, sc);
                    break;

                case 5:
                    searchStudents(students, n, sc);
                    break;

                case 6:
                    System.out.println("cảm ơn bạn đã sử dụng chương trình.");
                    sc.close();
                    return;

                default:
                    System.out.println("lựa chọn không hợp lệ (1-6).");
            }
        }
    }
}
