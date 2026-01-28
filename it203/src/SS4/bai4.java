package SS4;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class bai4 {
    public static void main(String[] args) {

        String cardID = "TV202312345";

        String regex = "^[A-Z]{2}\\d{4}\\d{5}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cardID);

        if (matcher.matches()) {
            System.out.println("Mã thẻ hợp lệ!");
        } else {
            if (!cardID.matches("^[A-Z]{2}.*")) {
                System.out.println("Thiếu tiền tố TV");
            } else if (!cardID.matches("^[A-Z]{2}\\d{4}.*")) {
                System.out.println("Năm không hợp lệ");
            } else {
                System.out.println("Định dạng mã thẻ không hợp lệ");
            }
        }
    }
}
