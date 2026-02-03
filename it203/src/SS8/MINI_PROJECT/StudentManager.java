package SS8.MINI_PROJECT;

public class StudentManager {
    private final Student[] students = new Student[100];
    private int count = 0;

    public int size() {
        return count;
    }

    public boolean addStudent(Student s) {
        if (count == students.length) return false;
        if (findById(s.getId()) != null) return false;
        students[count++] = s;
        return true;
    }

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

    public Student findById(String id) {
        for (int i = 0; i < count; i++) {
            if (students[i].getId().equalsIgnoreCase(id)) return students[i];
        }
        return null;
    }

    // trả về số lượng tìm thấy để main quyết định in/thông báo
    public int findByName(String keyword) {
        int found = 0;
        String k = keyword.toLowerCase();
        for (int i = 0; i < count; i++) {
            if (students[i].getName().toLowerCase().contains(k)) {
                System.out.println(students[i]);
                found++;
            }
        }
        return found;
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

    public int findByRank(String rankKey) {
        int found = 0;
        for (int i = 0; i < count; i++) {
            if (students[i].getRank().equalsIgnoreCase(rankKey)) {
                System.out.println(students[i]);
                found++;
            }
        }
        return found;
    }

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
