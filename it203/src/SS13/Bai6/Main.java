package SS13.Bai6;

import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Patient> patients = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== QUẢN LÝ HỒ SƠ BỆNH ÁN =====");
            System.out.println("1. Tiếp nhận bệnh nhân");
            System.out.println("2. Cập nhật chẩn đoán");
            System.out.println("3. Xuất viện");
            System.out.println("4. Sắp xếp danh sách");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> addPatient();
                case 2 -> updateDiagnosis();
                case 3 -> removePatient();
                case 4 -> sortPatients();
                case 5 -> {
                    System.out.println("Thoát chương trình!");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    static void addPatient() {
        System.out.print("ID: ");
        String id = sc.nextLine();

        for (Patient p : patients) {
            if (p.getId().equals(id)) {
                System.out.println(" ID đã tồn tại!");
                return;
            }
        }

        System.out.print("Họ tên: ");
        String name = sc.nextLine();
        System.out.print("Tuổi: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Chẩn đoán: ");
        String diagnosis = sc.nextLine();

        patients.add(new Patient(id, name, age, diagnosis));
        System.out.println(" Thêm bệnh nhân thành công!");
    }

    static void updateDiagnosis() {
        System.out.print("Nhập ID bệnh nhân: ");
        String id = sc.nextLine();

        for (Patient p : patients) {
            if (p.getId().equals(id)) {
                System.out.print("Chẩn đoán mới: ");
                p.setDiagnosis(sc.nextLine());
                System.out.println(" Cập nhật thành công!");
                return;
            }
        }
        System.out.println(" Không tìm thấy bệnh nhân!");
    }

    static void removePatient() {
        System.out.print("Nhập ID cần xuất viện: ");
        String id = sc.nextLine();

        Iterator<Patient> it = patients.iterator();
        while (it.hasNext()) {
            if (it.next().getId().equals(id)) {
                it.remove();
                System.out.println("✅ Đã xuất viện!");
                return;
            }
        }
        System.out.println("Không tìm thấy bệnh nhân!");
    }

    static void sortPatients() {
        patients.sort((a, b) -> {
            if (b.getAge() != a.getAge())
                return b.getAge() - a.getAge();
            return a.getFullName().compareToIgnoreCase(b.getFullName());
        });

        System.out.printf("%-10s %-20s %-5s %-20s\n",
                "ID", "Họ Tên", "Tuổi", "Chẩn Đoán");
        for (Patient p : patients) {
            System.out.println(p);
        }
    }
}