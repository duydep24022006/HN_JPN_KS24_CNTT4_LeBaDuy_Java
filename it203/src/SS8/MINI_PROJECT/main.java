package SS8.MINI_PROJECT;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        int choice;

        do {
            System.out.println("\n===== QUẢN LÝ SINH VIÊN =====");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Tìm kiếm");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Thống kê");
            System.out.println("9. Thoát");
            System.out.print("Chọn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Tên: ");
                    String name = sc.nextLine();
                    System.out.print("Tuổi: ");
                    int age = Integer.parseInt(sc.nextLine());
                    System.out.print("Giới tính: ");
                    String gender = sc.nextLine();
                    System.out.print("Toán: ");
                    double m = Double.parseDouble(sc.nextLine());
                    System.out.print("Lý: ");
                    double p = Double.parseDouble(sc.nextLine());
                    System.out.print("Hóa: ");
                    double c = Double.parseDouble(sc.nextLine());

                    boolean ok = manager.addStudent(
                            new Student(id, name, age, gender, m, p, c)
                    );
                    System.out.println(ok ? "Thêm thành công!" : "Thêm thất bại!");
                    break;

                case 2:
                    manager.showAll();
                    break;

                case 3:
                    System.out.print("Nhập tên cần tìm: ");
                    manager.findByName(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Nhập ID cần xóa: ");
                    System.out.println(manager.deleteById(sc.nextLine())
                            ? "Đã xóa" : "Không tìm thấy");
                    break;

                case 5:
                    manager.sortByAverageDesc();
                    System.out.println("Đã sắp xếp theo điểm TB giảm dần");
                    break;

                case 6:
                    manager.statistic();
                    break;
            }
        } while (choice != 9);
    }
}
