package SS9.bai5;

public class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    // method chung, lớp con sẽ override
    public double calculateSalary() {
        return 0;
    }

    public String getRole() {
        return "Employee";
    }

    public String getSalaryDetail() {
        return "";
    }

    public String getName() {
        return name;
    }
}
