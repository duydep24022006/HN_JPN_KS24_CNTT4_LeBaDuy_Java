package SS14.Bai1;

public class Student extends Person {
    private String maSV;
    private double diemTB;

    public Student(String hoTen, int tuoi, String maSV, double diemTB) {
        super(hoTen, tuoi);   // gọi constructor lớp cha
        this.maSV = maSV;
        this.diemTB = diemTB;
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin(); // KHÔNG lặp code
        System.out.println("Mã sinh viên: " + maSV);
        System.out.println("Điểm trung bình: " + diemTB);
    }
}