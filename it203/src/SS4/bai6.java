package SS4;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class bai6 {
    public static void main(String[] args) {

        // review fix cứng như đề
        String review = "Cuốn sách này rất tệ, nội dung thật là ngu ngốc và không đáng đọc.";

        String[] blacklist = {"tệ", "ngu ngốc", "không đáng"};

        for (String badWord : blacklist) {
            String regex = "(?i)" + badWord;
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(review);

            String stars = "*".repeat(badWord.length());
            review = matcher.replaceAll(stars);
        }

        if (review.length() > 200) {
            String sub = review.substring(0, 200);
            int lastSpace = sub.lastIndexOf(" ");
            StringBuilder sb = new StringBuilder();
            sb.append(sub.substring(0, lastSpace));
            sb.append("...");
            review = sb.toString();
        }

        System.out.println("Review sau khi xử lý: " + review);
    }
}
