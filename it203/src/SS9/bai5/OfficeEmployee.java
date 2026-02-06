package SS9.bai5;

public class OfficeEmployee extends Employee {
    private double baseSalary;

    public OfficeEmployee(String name, double baseSalary) {
        super(name);
        this.baseSalary = baseSalary;
    }

    @Override
    public double calculateSalary() {
        return baseSalary;
    }

    @Override
    public String getRole() {
        return "Office";
    }

    @Override
    public String getSalaryDetail() {
        return formatMoney(baseSalary);
    }

    private String formatMoney(double amount) {
        return String.format("%,.0f", amount);
    }
}
