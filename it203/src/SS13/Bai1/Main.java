package SS13.Bai1;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        // 1️⃣ Tạo danh sách thân nhiệt ban đầu
        ArrayList<Double> temperatures = new ArrayList<>();
        temperatures.add(36.5);
        temperatures.add(40.2);
        temperatures.add(37.0);
        temperatures.add(12.5);
        temperatures.add(39.8);
        temperatures.add(99.9);
        temperatures.add(36.8);

        System.out.println("Danh sách ban đầu: " + temperatures);

        // 2️⃣ Dùng Iterator để lọc dữ liệu không hợp lệ
        Iterator<Double> iterator = temperatures.iterator();
        while (iterator.hasNext()) {
            double temp = iterator.next();
            if (temp < 34.0 || temp > 42.0) {
                iterator.remove(); // ❗ XÓA AN TOÀN
            }
        }

        System.out.println("Danh sách sau khi lọc: " + temperatures);

        // 3️⃣ Tính nhiệt độ trung bình
        double sum = 0;
        for (double temp : temperatures) {
            sum += temp;
        }

        double average = sum / temperatures.size();
        System.out.printf("Nhiệt độ trung bình: %.2f\n", average);
    }
}