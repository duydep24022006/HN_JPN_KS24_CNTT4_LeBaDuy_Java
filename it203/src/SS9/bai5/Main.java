package SS9.bai5;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {

    List<Employee> employees = new ArrayList<>();

    employees.add(new OfficeEmployee("Nguyen Van A", 10_000_000));
    employees.add(new ProductionEmployee("Tran Thi B", 300, 20_000));
    employees.add(new ProductionEmployee("Le Van C", 150, 30_000));

    System.out.println("Danh sách lương nhân viên:");

    double total = 0;

    for (int i = 0; i < employees.size(); i++) {
        Employee e = employees.get(i);

        double salary = e.calculateSalary();
        total += salary;

        System.out.printf(
                "%d. %s (%s) - Lương: %s%n",
                (i + 1),
                e.getName(),
                e.getRole(),
                e.getSalaryDetail()
        );
    }

    System.out.println();
    System.out.println("=> TỔNG LƯƠNG CÔNG TY: " + String.format("%,.0f", total));
}
}
