package SS14.Bai5;

public abstract class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public abstract double calculateSalary();

    public String getName() {
        return name;
    }
}
