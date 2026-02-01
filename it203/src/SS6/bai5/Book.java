package SS6.bai5;

public class Book {
    private String maSach;
    private String tenSach;
    private double gia;

    public Book(String maSach, String tenSach, double gia) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "Book{" +
                "maSach='" + maSach + '\'' +
                ", tenSach='" + tenSach + '\'' +
                ", gia=" + gia +
                '}';
    }
}
