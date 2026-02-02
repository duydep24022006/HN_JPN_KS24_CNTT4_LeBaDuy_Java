package SS7.Bai1;

public class main {

    public static void main(String[] args) {
        Student st1=new Student("1","duy");
        Student st2=new Student("2","duy2");
        System.out.println(st1);
        System.out.println("-----------------------------");
        System.out.println(st2);
        System.out.println("Tổng số sinh viên đã tạo: "+Student.totalStudent);
    }
}
