package SS9.bai3;

public class Employee {
    protected String name;
    protected double basicSalary;

    public Employee(String name, double basicSalary) {
        this.name = name;
        this.basicSalary = basicSalary;
    }

    public void displayInfo() {
        System.out.println("Tên nhân viên: " + name);
        System.out.println("Lương cơ bản: " + basicSalary);
    }
}
