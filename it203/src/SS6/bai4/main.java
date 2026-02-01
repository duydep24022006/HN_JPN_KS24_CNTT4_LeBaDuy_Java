package SS6.bai4;

public class main {
    public static void main(String[] args) {
        Employee e1 = new Employee("nv01", "nguyễn văn a", 10000000);
        Employee e2 = new Employee("nv02", "trần thị b", 12000000);
        Employee e3 = new Employee();

        e1.hienThi();
        e2.hienThi();

        System.out.println("tổng số nhân viên: " + Employee.getSoLuongNhanVien());
    }
}
