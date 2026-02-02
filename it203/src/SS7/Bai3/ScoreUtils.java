package SS7.Bai3;

public class ScoreUtils {
    public static boolean checkPass(double score) {
        return score>=5.0;
    }

    public static double calculateAverage(double[] scores) {
        if (scores == null || scores.length == 0) {
            return 0;
        }
        double sum = 0;
        for (double s : scores) {
            sum += s;
        }
        return sum / scores.length;
    }
}
