package SS14.Bai3;

public class Manager extends Employee {
    private String phongBan;

    public Manager(String ten, double luongCoBan, String phongBan) {
        super(ten, luongCoBan);   // GỌI constructor lớp cha
        this.phongBan = phongBan;
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin(); // dùng lại code lớp cha
        System.out.println("Phòng ban: " + phongBan);
    }
}
