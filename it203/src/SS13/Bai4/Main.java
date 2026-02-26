package SS13.Bai4;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        LinkedList<String> queue = new LinkedList<>();

        queue.addLast("A");
        queue.addLast("B");

        // Ca cấp cứu khẩn
        queue.addFirst("C");

        System.out.println("Đang cấp cứu: " + queue.poll());
        System.out.println("Đang khám: " + queue.poll());
        System.out.println("Đang khám: " + queue.poll());
    }
}
