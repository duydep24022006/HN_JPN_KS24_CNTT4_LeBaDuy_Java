package SS10.Bai5;

public class Main {
    public static void main(String[] args) {

        Employee e1 = new OfficeStaff("Nguyễn Văn A", 8000000);
        Employee e2 = new Manager("Trần Thị B", 12000000, 5000000);

        e1.printSalary();
        e2.printSalary();
    }
}
