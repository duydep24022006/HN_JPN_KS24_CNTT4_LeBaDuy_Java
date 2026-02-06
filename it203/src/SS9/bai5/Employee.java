package SS9.bai5;

public class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public abstract double calculateSalary();

    public abstract String getRole();

    public abstract String getSalaryDetail();

    public String getName() {
        return name;
    }
}
