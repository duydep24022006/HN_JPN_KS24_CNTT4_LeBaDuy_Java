package SS8.MINI_PROJECT;

public class StudentManager {
    private Student[] students = new Student[100];
    private int count = 0;

    /* ===== FR1: thêm sinh viên ===== */
    public boolean addStudent(Student s) {
        if (count == students.length) return false;
        if (findById(s.getId()) != null) return false;

        students[count++] = s;
        return true;
    }

    /* ===== FR2: hiển thị ===== */
    public void showAll() {
        if (count == 0) {
            System.out.println("Danh sách rỗng!");
            return;
        }

        System.out.printf("%-8s %-20s %-5s %-8s %-6s %-6s %-6s %-6s %-10s%n",
                "ID", "Tên", "Tuổi", "GT", "Toán", "Lý", "Hóa", "TB", "Xếp loại");
        for (int i = 0; i < count; i++) {
            System.out.println(students[i]);
        }
    }

    /* ===== FR3: tìm kiếm ===== */
    public Student findById(String id) {
        for (int i = 0; i < count; i++)
            if (students[i].getId().equalsIgnoreCase(id))
                return students[i];
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

    /* ===== FR5: xóa ===== */
    public boolean deleteById(String id) {
        for (int i = 0; i < count; i++) {
            if (students[i].getId().equalsIgnoreCase(id)) {
                for (int j = i; j < count - 1; j++)
                    students[j] = students[j + 1];
                students[--count] = null;
                return true;
            }
        }
        return false;
    }

    /* ===== FR7: sắp xếp ===== */
    public void sortByAverageDesc() {
        for (int i = 0; i < count - 1; i++)
            for (int j = i + 1; j < count; j++)
                if (students[i].getAverage() < students[j].getAverage()) {
                    Student tmp = students[i];
                    students[i] = students[j];
                    students[j] = tmp;
                }
    }

    public void sortByNameAZ() {
        for (int i = 0; i < count - 1; i++) {
            int min = i;
            for (int j = i + 1; j < count; j++)
                if (students[j].getName().compareToIgnoreCase(students[min].getName()) < 0)
                    min = j;
            Student tmp = students[i];
            students[i] = students[min];
            students[min] = tmp;
        }
    }

    /* ===== FR8: thống kê ===== */
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
}

