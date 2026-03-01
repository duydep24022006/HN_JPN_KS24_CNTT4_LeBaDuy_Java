package SS14.Bai5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new OfficeEmployee("Nguyen Van A", 10_000_000));
        employees.add(new ProductionEmployee("Tran Thi B", 300, 20_000));
        employees.add(new ProductionEmployee("Le Van C", 150, 30_000));

        double totalSalary = 0;

        System.out.println("Danh sách lương nhân viên:");

        int index = 1;
        for (Employee e : employees) {
            double salary = e.calculateSalary(); // ĐA HÌNH RUNTIME
            totalSalary += salary;

            System.out.println(
                    index + ". " + e.getName() +
                            " - Lương: " + String.format("%,.0f", salary)
            );
            index++;
        }

        System.out.println("=> TỔNG LƯƠNG CÔNG TY: " +
                String.format("%,.0f", totalSalary));
    }
}
