package SS9.bai1;

public class Student extends Person {
    private String studentId;
    private double gpa;

    public Student(String fullName, int age, String studentId, double gpa) {
        super(fullName, age); // gọi constructor lớp cha
        this.studentId = studentId;
        this.gpa = gpa;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Mã sinh viên: " + studentId);
        System.out.println("Điểm trung bình: " + gpa);
    }
}
