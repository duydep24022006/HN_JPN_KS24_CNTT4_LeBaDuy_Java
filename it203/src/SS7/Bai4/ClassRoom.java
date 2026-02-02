package SS7.Bai4;

public class ClassRoom {

    // biến instance
    private String name;

    // biến static - quỹ chung của lớp
    private static double classFund;

    // static block
    static {
        classFund = 0.0;
    }

    // constructor
    public ClassRoom(String name) {
        this.name = name;
    }

    // sinh viên đóng tiền vào quỹ
    public void payToFund(double amount) {
        if (amount > 0) {
            classFund += amount;
            System.out.println(name + " đã đóng " + amount);
        }
    }

    // xem tổng quỹ lớp
    public static double getClassFund() {
        return classFund;
    }

    // getter/setter name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
