package SS9.bai3;

public class Manager extends Employee {
    private String department;

    public Manager(String name, double basicSalary, String department) {
        super(name, basicSalary); // bắt buộc: dòng đầu tiên
        this.department = department;
    }

    @Override
    public void displayInfo() {
        super.displayInfo(); // gọi method của lớp cha
        System.out.println("Phòng ban: " + department);
    }
}
