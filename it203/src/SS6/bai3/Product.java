package SS6.bai3;

public class Product {
    private String msp;
    private String tenSanPham;
    private double giaBan;

    public Product(String msp, String tenSanPham, double giaBan) {
        this.msp = msp;
        this.tenSanPham = tenSanPham;
        this.giaBan = giaBan;
    }

    public String getMsp() {
        return msp;
    }

    public void setMsp(String msp) {
        this.msp = msp;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public double getGiaBan() {

        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        if (giaBan>=0){
            this.giaBan = giaBan;
        }else{
            System.out.println("giá phải lớn hơn 0");
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "msp='" + msp + '\'' +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", giaBan=" + giaBan +
                '}';
    }
}
