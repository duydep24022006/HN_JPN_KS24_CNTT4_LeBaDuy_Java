package SS7.Bai6;

import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private static final List<User> users = new ArrayList<>();

    public static void addUser(User u) {
        if (u == null) return;

        for (User existing : users) {
            if (existing.getUsername().equals(u.getUsername())) {
                System.out.println("Không thể thêm: username đã tồn tại -> " + u.getUsername());
                return;
            }
        }
        users.add(u);
    }

    public static boolean checkLogin(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void showAllUsers() {
        if (users.isEmpty()) {
            System.out.println("(Danh sách user rỗng)");
            return;
        }
        for (int i = 0; i < users.size(); i++) {
            System.out.println((i + 1) + ". " + users.get(i));
        }
    }
}

