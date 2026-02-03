package SS8.MINI_PROJECT;

import java.util.Scanner;

public class MainApp {
    static Scanner sc = new Scanner(System.in);

    static void menu() {
        System.out.println("\n===== QUẢN LÝ SINH VIÊN =====");
        System.out.println("1. Thêm sinh viên mới");
        System.out.println("2. Hiển thị tất cả sinh viên");
        System.out.println("3. Tìm kiếm sinh viên (mã hoặc tên)");
        System.out.println("4. Cập nhật thông tin sinh viên");
        System.out.println("5. Xóa sinh viên");
        System.out.println("6. Sắp xếp (1-Điểm TB giảm dần | 2-Tên A-Z)");
        System.out.println("7. Tìm theo xếp loại");
        System.out.println("8. Thống kê");
        System.out.println("9. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    static int readIntInRange(String msg, int min, int max) {
        while (true) {
            try {
                System.out.print(msg);
                int x = Integer.parseInt(sc.nextLine().trim());
                if (x < min || x > max) {
                    System.out.println("Giá trị phải trong khoảng " + min + " - " + max);
                    continue;
                }
                return x;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }
    }

    static double readDoubleInRange(String msg, double min, double max) {
        while (true) {
            try {
                System.out.print(msg);
                double x = Double.parseDouble(sc.nextLine().trim());
                if (x < min || x > max) {
                    System.out.println("Giá trị phải trong khoảng " + min + " - " + max);
                    continue;
                }
                return x;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }
    }

    static String readNonEmpty(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Không được để trống!");
        }
    }

    static String readGender() {
        while (true) {
            System.out.print("Nhập giới tính (Nam/Nữ): ");
            String g = sc.nextLine().trim();
            if (g.equalsIgnoreCase("Nam")) return "Nam";
            if (g.equalsIgnoreCase("Nữ") || g.equalsIgnoreCase("Nu")) return "Nữ";
            System.out.println("Chỉ nhập Nam hoặc Nữ!");
        }
    }

    static String readStudentIdNew(StudentManager manager) {
        while (true) {
            String id = readNonEmpty("Nhập mã SV (SVxxx): ");
            if (!id.matches("SV\\d{3}")) {
                System.out.println("Sai định dạng! Ví dụ: SV001");
                continue;
            }
            if (manager.findById(id) != null) {
                System.out.println("Mã SV đã tồn tại!");
                continue;
            }
            return id;
        }
    }

    static String readExistingId(StudentManager manager) {
        while (true) {
            String id = readNonEmpty("Nhập mã SV: ");
            if (manager.findById(id) == null) {
                System.out.println("Không tìm thấy mã SV này!");
                continue;
            }
            return id;
        }
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        int choice;

        do {
            menu();
            choice = readIntInRange("", 1, 9);

            switch (choice) {
                case 1: { // thêm
                    String id = readStudentIdNew(manager);
                    String name = readNonEmpty("Nhập họ tên: ");
                    int age = readIntInRange("Nhập tuổi (18-30): ", 18, 30);
                    String gender = readGender();
                    double math = readDoubleInRange("Điểm Toán (0-10): ", 0, 10);
                    double physics = readDoubleInRange("Điểm Lý (0-10): ", 0, 10);
                    double chemistry = readDoubleInRange("Điểm Hóa (0-10): ", 0, 10);

                    boolean ok = manager.addStudent(new Student(id, name, age, gender, math, physics, chemistry));
                    System.out.println(ok ? "Thêm thành công!" : "Thêm thất bại (mảng đầy hoặc trùng mã)!");
                    break;
                }
                case 2: // hiển thị
                    manager.showAll();
                    break;

                case 3: { // tìm
                    String key = readNonEmpty("Nhập mã SV hoặc tên cần tìm: ");
                    Student byId = manager.findById(key);
                    if (byId != null) {
                        System.out.println(byId);
                    } else {
                        int found = manager.findByName(key);
                        if (found == 0) System.out.println("Không tìm thấy!");
                    }
                    break;
                }

                case 4: { // cập nhật
                    String id = readExistingId(manager);

                    String name = readNonEmpty("Nhập họ tên mới: ");
                    int age = readIntInRange("Nhập tuổi mới (18-30): ", 18, 30);
                    String gender = readGender();
                    double math = readDoubleInRange("Điểm Toán (0-10): ", 0, 10);
                    double physics = readDoubleInRange("Điểm Lý (0-10): ", 0, 10);
                    double chemistry = readDoubleInRange("Điểm Hóa (0-10): ", 0, 10);

                    boolean ok = manager.updateById(id, name, age, gender, math, physics, chemistry);
                    System.out.println(ok ? "Cập nhật thành công!" : "Cập nhật thất bại!");
                    break;
                }

                case 5: { // xóa
                    String id = readNonEmpty("Nhập mã SV cần xóa: ");
                    Student s = manager.findById(id);
                    if (s == null) {
                        System.out.println("Không tìm thấy!");
                        break;
                    }

                    System.out.print("Bạn chắc chắn muốn xóa? (Y/N): ");
                    String confirm = sc.nextLine().trim();
                    if (confirm.equalsIgnoreCase("Y")) {
                        System.out.println(manager.deleteById(id) ? "Đã xóa!" : "Xóa thất bại!");
                    } else {
                        System.out.println("Đã hủy xóa!");
                    }
                    break;
                }

                case 6: { // sắp xếp
                    int opt = readIntInRange("Chọn kiểu sắp xếp (1/2): ", 1, 2);
                    if (opt == 1) {
                        manager.sortByAverageDesc();
                        System.out.println("Đã sắp xếp theo điểm TB giảm dần!");
                    } else {
                        manager.sortByNameAZ();
                        System.out.println("Đã sắp xếp theo tên A-Z!");
                    }
                    break;
                }

                case 7: { // tìm theo xếp loại
                    String rk = readNonEmpty("Nhập xếp loại (Giỏi/Khá/Trung bình/Yếu): ");
                    int found = manager.findByRank(rk);
                    if (found == 0) System.out.println("Không tìm thấy!");
                    break;
                }

                case 8: // thống kê
                    manager.statistic();
                    break;

                case 9:
                    System.out.println("Thoát chương trình!");
                    break;
            }
        } while (choice != 9);
    }
}
