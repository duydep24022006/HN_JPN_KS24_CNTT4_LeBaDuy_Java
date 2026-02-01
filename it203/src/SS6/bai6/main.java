package SS6.bai6;

public class main {
    public static void main(String[] args) {
        User u1 = new User(1, "khanh", "123456", "khanh@gmail.com");
        u1.hienThiThongTin();

        User u2 = new User(2, "duy", "abc123", "duy-gmail.com");
        u2.hienThiThongTin();

        User u3 = new User(3, "linh", "   ", "linh@gmail.com");
        u3.hienThiThongTin();

        u1.setEmail("sai_email");
        u1.setPassWord("");
        u1.hienThiThongTin();
    }
}
