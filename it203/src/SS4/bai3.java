package SS4;

public class bai3 {
    public static void main(String[] args) {

        String[] transactions = {"BK001-20/01", "BK005-21/01", "BK099-22/01"};

        String createdDate = "24/01/2026";

        long startSB = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder();
        sb.append("--- BÁO CÁO MƯỢN SÁCH ---\n");
        sb.append("Ngày tạo: ").append(createdDate).append("\n");
        for (String t : transactions) {
            sb.append("Giao dịch: ").append(t).append("\n");
        }

        long endSB = System.currentTimeMillis();

        long startStr = System.currentTimeMillis();

        String report = "";
        report += "--- BÁO CÁO MƯỢN SÁCH ---\n";
        report += "Ngày tạo: " + createdDate + "\n";
        for (String t : transactions) {
            report += "Giao dịch: " + t + "\n";
        }

        long endStr = System.currentTimeMillis();

        System.out.print(sb.toString());
        System.out.println();

        System.out.println("Số thời gian thực thi đối với StringBuilder: " + (endSB - startSB));
        System.out.println("Số thời gian thực thi đối với String: " + (endStr - startStr));
    }
}
