package SS10.Bai6;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 1500));
        products.add(new Product("Phone", 800));
        products.add(new Product("Tablet", 1200));


        Collections.sort(products, new Comparator<Product>() {



            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.price, p2.price);
            }
        });

        System.out.println("Danh sách sắp xếp theo GIÁ (tăng dần):");
        for (Product p : products) {
            System.out.println(p);
        }


        products.sort((p1, p2) -> p1.name.compareTo(p2.name));

        System.out.println("\nDanh sách sắp xếp theo TÊN (A-Z):");
        for (Product p : products) {
            System.out.println(p);
        }
    }
}