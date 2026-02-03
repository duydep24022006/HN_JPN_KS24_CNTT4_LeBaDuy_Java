package SS8.HN_KS24_CNTT4_B24DTCN205;

import java.util.Scanner;

public class main {
    static Scanner sc = new Scanner(System.in);
    static Student[] students = new Student[100];
    static int count = 0;

    static void displayMenu() {
        System.out.println("\n===== QUẢN LÝ ĐIỂM SINH VIÊN =====");
        System.out.println("1. Nhập danh sách sinh viên");
        System.out.println("2. Hiển thị danh sách sinh viên");
        System.out.println("3. Tìm kiếm sinh viên theo Học lực");
        System.out.println("4. Sắp xếp theo học lực giảm dần");
        System.out.println("5. Thoát");
        System.out.println("==================================");
        System.out.print("Chọn chức năng: ");
    }

    static boolean isValidId(String id) {
        return id.matches("SV\\d{3}");
    }

    static void inputStudents() {
        System.out.print("Nhập số lượng sinh viên: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("Sinh viên thứ " + (i + 1));

            String id;
            do {
                System.out.print("Nhập mã SV (SVxxx): ");
                id = sc.nextLine();
            } while (!isValidId(id));

            System.out.print("Nhập họ tên: ");
            String name = sc.nextLine();

            System.out.print("Nhập điểm TB: ");
            double score = Double.parseDouble(sc.nextLine());

            students[count++] = new Student(id, name, score);
        }
    }

    static void showStudents() {
        if (count == 0) {
            System.out.println("Danh sách rỗng!");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(students[i]);
        }
    }

    static void findByRank() {
        System.out.print("Nhập học lực cần tìm (Gioi/Kha/Trung Binh): ");
        String key = sc.nextLine();

        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (students[i].getRank().equalsIgnoreCase(key)) {
                System.out.println(students[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sinh viên phù hợp!");
        }
    }

    static void sortByScoreDesc() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (students[i].getScore() < students[j].getScore()) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp theo học lực giảm dần!");
    }

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    inputStudents();
                    break;
                case 2:
                    showStudents();
                    break;
                case 3:
                    findByRank();
                    break;
                case 4:
                    sortByScoreDesc();
                    break;
                case 5:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 5);
    }
}
