package SS6.bai6;

public class User {
    private int id;
    private String userName;
    private String passWord;
    private String email;

    public User(int id, String userName, String passWord, String email) {
        this.id = id;
        this.userName = userName;

        setPassWord(passWord);
        setEmail(email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        if (passWord == null || passWord.trim().isEmpty()) {
            System.out.println("password không được rỗng!");
            return; // không gán
        }
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!isValidEmail(email)) {
            System.out.println("email không hợp lệ!");
            return; // không gán
        }
        this.email = email;
    }

    private boolean isValidEmail(String email) {
        if (email == null) return false;
        String e = email.trim();
        return e.matches("^[\\w._%+-]+@[\\w.-]+\\.[A-Za-z]{2,}$");
    }

    public void hienThiThongTin() {
        System.out.println("id: " + id);
        System.out.println("username: " + userName);
        System.out.println("password: " + "******");
        System.out.println("email: " + email);
        System.out.println("----------------------");
    }
}
