package SS6.bai1;

import java.util.Date;

public class Student {
    private String msv;
    private String hoTen;
    private Date namSinh;
    private double diemTrungBinh;

    public Student() {
    }

    public Student(String msv, String hoTen, Date namSinh, double diemTrungBinh) {
        this.msv = msv;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.diemTrungBinh = diemTrungBinh;
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(Date namSinh) {
        this.namSinh = namSinh;
    }

    public double getDiemTrungBinh() {
        return diemTrungBinh;
    }

    public void setDiemTrungBinh(double diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }
    public void renderStudent() {
        System.out.println("mã sv: " + this.msv);
        System.out.println("họ tên: " + this.hoTen);
        System.out.println("năm sinh: " + this.namSinh);
        System.out.println("điểm tb: " + this.diemTrungBinh);
        System.out.println("--------------------");


    }
}
