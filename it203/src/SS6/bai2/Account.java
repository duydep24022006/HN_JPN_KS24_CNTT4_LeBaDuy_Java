package SS6.bai2;

import com.sun.source.doctree.EscapeTree;

public class Account {
    private String userName;
    private String passWord;
    private String email;

    public Account(String userName, String passWord, String email) {
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
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
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void renderAccount () {
        System.out.println("userName: " + this.userName);
        System.out.println("email: " + this.email);
        System.out.println("--------------------");


    }
}
