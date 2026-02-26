package SS13.Bai5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static ArrayList<Patient> patients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== QUẢN LÝ HỒ SƠ BỆNH ÁN =====");
            System.out.println("1. Tiếp nhận bệnh nhân");
            System.out.println("2. Cập nhật chẩn đoán");
            System.out.println("3. Xuất viện");
            System.out.println("4. Sắp xếp danh sách bệnh nhân");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> addPatient();
                case 2 -> updateDiagnosis();
                case 3 -> removePatient();
                case 4 -> sortPatients();
                case 5 -> System.out.println("Thoát chương trình.");
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 5);
    }

    static void addPatient() {
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();

        for (Patient p : patients) {
            if (p.getId().equalsIgnoreCase(id)) {
                System.out.println(" ID đã tồn tại!");
                return;
            }
        }

        System.out.print("Nhập họ tên: ");
        String name = sc.nextLine();

        System.out.print("Nhập tuổi: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập chẩn đoán: ");
        String diagnosis = sc.nextLine();

        patients.add(new Patient(id, name, age, diagnosis));
        System.out.println("✅ Tiếp nhận bệnh nhân thành công.");
    }

    static void updateDiagnosis() {
        System.out.print("Nhập ID bệnh nhân: ");
        String id = sc.nextLine();

        for (Patient p : patients) {
            if (p.getId().equalsIgnoreCase(id)) {
                System.out.print("Nhập chẩn đoán mới: ");
                p.setDiagnosis(sc.nextLine());
                System.out.println("✅ Cập nhật thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy bệnh nhân.");
    }

    static void removePatient() {
        System.out.print("Nhập ID bệnh nhân xuất viện: ");
        String id = sc.nextLine();

        for (Patient p : patients) {
            if (p.getId().equalsIgnoreCase(id)) {
                patients.remove(p);
                System.out.println(" Đã xuất viện bệnh nhân.");
                return;
            }
        }
        System.out.println(" Không tìm thấy bệnh nhân.");
    }

    static void sortPatients() {
        patients.sort(
                Comparator.comparingInt(Patient::getAge).reversed()
                        .thenComparing(Patient::getFullName)
        );

        System.out.println("📋 Danh sách bệnh nhân sau sắp xếp:");
        for (Patient p : patients) {
            System.out.println(p);
        }
    }
}