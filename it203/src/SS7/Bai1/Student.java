package SS7.Bai1;

public class Student {
    private String msv;
    private String tenSinhVien;
    public static int totalStudent;
    static {
        totalStudent=0;
    }
    public Student(String msv, String tenSinhVien) {
        this.msv = msv;
        this.tenSinhVien = tenSinhVien;
        totalStudent++;
    }
    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    @Override
    public String toString() {
        return "Student{" +
                "msv='" + msv + '\'' +
                ", tenSinhVien='" + tenSinhVien + '\'' +
                '}';
    }
}
