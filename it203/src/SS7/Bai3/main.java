package SS7.Bai3;

public class main {
    public static void main(String[] args) {

        double[] scores = {6.5, 8.0, 4.5};

        System.out.println("Danh sách điểm: 6.5, 8.0, 4.5");
        System.out.println("\n>> Kết quả xử lý:");

        double avg = ScoreUtils.calculateAverage(scores);
        System.out.printf("- Điểm trung bình cả lớp: %.2f\n", avg);

        for (double score : scores) {
            boolean pass = ScoreUtils.checkPass(score);
            System.out.println("- Điểm " + score + ": " + (pass ? "Đạt" : "Trượt"));
        }
    }
}
