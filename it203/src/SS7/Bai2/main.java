package SS7.Bai2;

public class main {
    public static void main(String[] args) {

        // ===== biến nguyên thủy =====
        int a = 10;
        int b = a;     // gán giá trị

        b = 20;

        System.out.println("a = " + a); // ?
        System.out.println("b = " + b); // ?

        System.out.println("------------");

        // ===== biến tham chiếu =====
        Student s1 = new Student("An");
        Student s2 = s1;   // gán tham chiếu (địa chỉ)

        s2.name = "Bình"; // thay đổi qua s2

        System.out.println("s1.name = " + s1.name);
        System.out.println("s2.name = " + s2.name);
    }
}
