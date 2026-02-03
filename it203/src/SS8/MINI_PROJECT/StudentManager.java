package SS8.MINI_PROJECT;

import java.util.Scanner;

public class StudentManager {
    private final Student[] students = new Student[100];
    private int count = 0;

    private final Scanner sc = new Scanner(System.in);

    // ===== MENU =====
    public void showMenu() {
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
    }

    public int readMenuChoice() {
        return readIntInRange("Chọn chức năng: ", 1, 9);
    }

    // =========================
    // CASE 1: THÊM SINH VIÊN
    // =========================
    public void addStudentFlow() {
        String id = readStudentIdNew();
        String name = readNonEmpty("Nhập họ tên: ");
        int age = readIntInRange("Nhập tuổi (18-30): ", 18, 30);
        String gender = readGender();
        double math = readDoubleInRange("Điểm Toán (0-10): ", 0, 10);
        double physics = readDoubleInRange("Điểm Lý (0-10): ", 0, 10);
        double chemistry = readDoubleInRange("Điểm Hóa (0-10): ", 0, 10);

        boolean ok = addStudent(new Student(id, name, age, gender, math, physics, chemistry));
        System.out.println(ok ? "Thêm thành công!" : "Thêm thất bại (mảng đầy hoặc trùng mã)!");
    }

    // =========================
    // CASE 2: HIỂN THỊ DANH SÁCH
    // =========================
    public void showAll() {
        if (count == 0) {
            System.out.println("Danh sách rỗng!");
            return;
        }

        System.out.printf("%-8s | %-20s | %-4s | %-7s | %-4s | %-4s | %-4s | %-5s | %-10s%n",
                "ID", "Tên", "Tuổi", "GT", "Toán", "Lý", "Hóa", "TB", "Xếp loại");
        System.out.println("--------------------------------------------------------------------------------");

        for (int i = 0; i < count; i++) {
            System.out.println(students[i]);
        }
    }

    // =========================
    // CASE 3: TÌM KIẾM (MÃ/TÊN)
    // =========================
    public void searchFlow() {
        String key = readNonEmpty("Nhập mã SV hoặc tên cần tìm: ");
        Student byId = findById(key);
        if (byId != null) {
            System.out.println(byId);
        } else {
            findByName(key);
        }
    }

    // =========================
    // CASE 4: CẬP NHẬT SINH VIÊN
    // =========================
    public void updateStudentFlow() {
        String id = readExistingId();

        String name = readNonEmpty("Nhập họ tên mới: ");
        int age = readIntInRange("Nhập tuổi mới (18-30): ", 18, 30);
        String gender = readGender();
        double math = readDoubleInRange("Điểm Toán (0-10): ", 0, 10);
        double physics = readDoubleInRange("Điểm Lý (0-10): ", 0, 10);
        double chemistry = readDoubleInRange("Điểm Hóa (0-10): ", 0, 10);

        boolean ok = updateById(id, name, age, gender, math, physics, chemistry);
        System.out.println(ok ? "Cập nhật thành công!" : "Cập nhật thất bại!");
    }

    // =========================
    // CASE 5: XÓA SINH VIÊN
    // =========================
    public void deleteStudentFlow() {
        String id = readNonEmpty("Nhập mã SV cần xóa: ");
        Student s = findById(id);
        if (s == null) {
            System.out.println("Không tìm thấy!");
            return;
        }

        System.out.print("Bạn chắc chắn muốn xóa? (Y/N): ");
        String confirm = sc.nextLine().trim();
        if (confirm.equalsIgnoreCase("Y")) {
            System.out.println(deleteById(id) ? "Đã xóa!" : "Xóa thất bại!");
        } else {
            System.out.println("Đã hủy xóa!");
        }
    }

    // =========================
    // CASE 6: SẮP XẾP
    // =========================
    public void sortFlow() {
        int opt = readIntInRange("Chọn kiểu sắp xếp (1/2): ", 1, 2);
        if (opt == 1) {
            sortByAverageDesc();
            System.out.println("Đã sắp xếp theo điểm TB giảm dần!");
        } else {
            sortByNameAZ();
            System.out.println("Đã sắp xếp theo tên A-Z!");
        }
    }

    // =========================
    // CASE 7: TÌM THEO XẾP LOẠI
    // =========================
    public void findByRankFlow() {
        String rk = readNonEmpty("Nhập xếp loại (Giỏi/Khá/Trung bình/Yếu): ");
        findByRank(rk);
    }

    // =========================
    // CASE 8: THỐNG KÊ
    // =========================
    public void statistic() {
        int gioi = 0, kha = 0, tb = 0, yeu = 0;
        double sum = 0;

        for (int i = 0; i < count; i++) {
            sum += students[i].getAverage();
            switch (students[i].getRank()) {
                case "Giỏi": gioi++; break;
                case "Khá": kha++; break;
                case "Trung bình": tb++; break;
                default: yeu++;
            }
        }

        System.out.println("Giỏi: " + gioi);
        System.out.println("Khá: " + kha);
        System.out.println("Trung bình: " + tb);
        System.out.println("Yếu: " + yeu);
        System.out.printf("Điểm TB chung: %.2f%n", count == 0 ? 0 : sum / count);
    }


    // ======================================================
    // INPUT + VALIDATE (HÀM HỖ TRỢ - DÙNG CHUNG)
    // ======================================================
    private int readIntInRange(String msg, int min, int max) {
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

    private double readDoubleInRange(String msg, double min, double max) {
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

    private String readNonEmpty(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Không được để trống!");
        }
    }

    private String readGender() {
        while (true) {
            System.out.print("Nhập giới tính (Nam/Nữ): ");
            String g = sc.nextLine().trim();
            if (g.equalsIgnoreCase("Nam")) return "Nam";
            if (g.equalsIgnoreCase("Nữ") || g.equalsIgnoreCase("Nu")) return "Nữ";
            System.out.println("Chỉ nhập Nam hoặc Nữ!");
        }
    }

    private String readStudentIdNew() {
        while (true) {
            System.out.print("Nhập mã SV (SVxxx): ");
            String id = sc.nextLine().trim();

            if (!id.matches("SV\\d{3}")) {
                System.out.println("Sai định dạng! Ví dụ: SV001");
                continue;
            }
            if (findById(id) != null) {
                System.out.println("Mã SV đã tồn tại!");
                continue;
            }
            return id;
        }
    }

    private String readExistingId() {
        while (true) {
            String id = readNonEmpty("Nhập mã SV: ");
            if (findById(id) == null) {
                System.out.println("Không tìm thấy mã SV này!");
                continue;
            }
            return id;
        }
    }

    // ======================================================
    // CORE FUNCTIONS (XỬ LÝ DỮ LIỆU - DÙNG CHO CÁC CASE)
    // ======================================================
    public boolean addStudent(Student s) {
        if (count == students.length) return false;
        if (findById(s.getId()) != null) return false;
        students[count++] = s;
        return true;
    }

    public Student findById(String id) {
        for (int i = 0; i < count; i++) {
            if (students[i].getId().equalsIgnoreCase(id)) return students[i];
        }
        return null;
    }

    public void findByName(String keyword) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (students[i].getName().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(students[i]);
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy!");
    }

    public void findByRank(String rankKey) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (students[i].getRank().equalsIgnoreCase(rankKey)) {
                System.out.println(students[i]);
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy!");
    }

    public boolean deleteById(String id) {
        for (int i = 0; i < count; i++) {
            if (students[i].getId().equalsIgnoreCase(id)) {
                for (int j = i; j < count - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[--count] = null;
                return true;
            }
        }
        return false;
    }

    public boolean updateById(String id, String newName, int newAge, String newGender,
                              double newMath, double newPhysics, double newChemistry) {
        Student s = findById(id);
        if (s == null) return false;

        s.setName(newName);
        s.setAge(newAge);
        s.setGender(newGender);
        s.setMath(newMath);
        s.setPhysics(newPhysics);
        s.setChemistry(newChemistry);
        return true;
    }

    public void sortByAverageDesc() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (students[i].getAverage() < students[j].getAverage()) {
                    Student tmp = students[i];
                    students[i] = students[j];
                    students[j] = tmp;
                }
            }
        }
    }

    public void sortByNameAZ() {
        for (int i = 0; i < count - 1; i++) {
            int min = i;
            for (int j = i + 1; j < count; j++) {
                if (students[j].getName().compareToIgnoreCase(students[min].getName()) < 0) {
                    min = j;
                }
            }
            Student tmp = students[i];
            students[i] = students[min];
            students[min] = tmp;
        }
    }
}
