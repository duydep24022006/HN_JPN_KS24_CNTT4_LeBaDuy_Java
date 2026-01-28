package SS4;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class bai5 {
    public static void main(String[] args) {

        String log = "2024-05-20 | User: NguyenVanA | Action: BORROW | BookID: BK12345";

        String regex = "^(\\d{4}-\\d{2}-\\d{2}) \\| User: ([^|]+) \\| Action: (BORROW|RETURN) \\| BookID: (BK\\d+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(log);

        int borrow = 0;
        int ret = 0;

        if (matcher.matches()) {
            String date = matcher.group(1);
            String user = matcher.group(2);
            String action = matcher.group(3);
            String bookId = matcher.group(4);

            System.out.println("Ngày: " + date);
            System.out.println("Người dùng: " + user);
            System.out.println("Hành động: " + action);
            System.out.println("Mã sách: " + bookId);

            if (action.equals("BORROW")) borrow++;
            if (action.equals("RETURN")) ret++;
        }

        System.out.println();
        System.out.println("BORROW: " + borrow);
        System.out.println("RETURN: " + ret);
    }
}
