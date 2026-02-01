package SS6.bai4;

public class Employee {
    private String maNV;
    private String hoTen;
    private double luong;

    // static: dùng chung cho tất cả nhân viên
    private static int soLuongNhanVien = 0;

    // constructor không tham số
    public Employee() {
        soLuongNhanVien++;
    }

    // constructor có tham số
    public Employee(String maNV, String hoTen, double luong) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.luong = luong;
        soLuongNhanVien++;
    }

    // phương thức hiển thị
    public void hienThi() {
        System.out.println("mã nv: " + maNV);
        System.out.println("họ tên: " + hoTen);
        System.out.println("lương: " + luong);
        System.out.println("--------------------");
    }

    // static method
    public static int getSoLuongNhanVien() {
        return soLuongNhanVien;
    }
}
