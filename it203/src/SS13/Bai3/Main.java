package SS13.Bai3;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static <T> List<T> findCommonPatients(List<T> listA, List<T> listB) {
        List<T> result = new ArrayList<>();

        for (T item : listA) {
            if (listB.contains(item) && !result.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        List<Integer> internalDept = List.of(101, 102, 105);
        List<Integer> surgeryDept  = List.of(102, 105, 108);

        List<Integer> commonIds =
                findCommonPatients(internalDept, surgeryDept);

        System.out.println("Test Case 1 Output: " + commonIds);

        List<String> bhytA = List.of("DN01", "DN02", "DN03");
        List<String> bhytB = List.of("DN02", "DN04");

        List<String> commonCodes =
                findCommonPatients(bhytA, bhytB);

        System.out.println("Test Case 2 Output: " + commonCodes);
    }
}
