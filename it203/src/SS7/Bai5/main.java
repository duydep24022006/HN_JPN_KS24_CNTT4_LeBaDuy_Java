package SS7.Bai5;

public class main {
    public static void main(String[] args) {

        double score = 8.5;
        double score2 = 10.5;

        if (score >= Config.MIN_SCORE && score <= Config.MAX_SCORE) {
            System.out.println("Điểm hợp lệ: " + score);
        } else {
            System.out.println("Điểm không hợp lệ!");
        }
        if (score2 >= Config.MIN_SCORE && score2 <= Config.MAX_SCORE) {
            System.out.println("Điểm hợp lệ: " + score2);
        } else {
            System.out.println("Điểm không hợp lệ!");
        }


    }
}
