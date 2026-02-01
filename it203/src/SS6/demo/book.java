package SS6.demo;

public class book {
    private String id;
    private String title;
    private double price;
    public book() {
    }
    public book(String id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void display() {
        System.out.println("mã sách: " + id);
        System.out.println("tên sách: " + title);
        System.out.println("giá: " + price);
    }

}
