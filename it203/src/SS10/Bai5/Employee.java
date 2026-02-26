package SS10.Bai5;

abstract class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public void printSalary() {
        System.out.println(
                "Nhân viên: " + name +
                        " | Lương cơ bản: " + baseSalary +
                        " | Lương thực nhận: " + calculateSalary()
        );
    }
}