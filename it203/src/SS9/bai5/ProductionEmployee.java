package SS9.bai5;

public class ProductionEmployee extends Employee {
    private int numOfProducts;
    private double price;

    public ProductionEmployee(String name, int numOfProducts, double price) {
        super(name);
        this.numOfProducts = numOfProducts;
        this.price = price;
    }

    @Override
    public double calculateSalary() {
        return numOfProducts * price;
    }

    @Override
    public String getRole() {
        return "Production";
    }

    @Override
    public String getSalaryDetail() {
        return String.format("%,.0f (%d sản phẩm * %,.0f)", calculateSalary(), numOfProducts, price);
    }
}
