package SS4;


public class bai2 {
    public static void main(String[] args) {
        String description="Sách giáo khoa Toán lớp 12, Kệ: A1-102,tình trạng mới";
        String tuKhoa="Kệ:";
        if(description.contains(tuKhoa)){
            int start=description.indexOf(tuKhoa)+tuKhoa.length();
            int end=description.indexOf(",",start);
            String viTri=description.substring(start,end).trim();
            String newDescription=description.replace(tuKhoa,"Vị trí lưu trữ:");

            System.out.println("Vị trí tìm thấy: "+viTri);
            System.out.println("Mô tả mới: "+newDescription);
        }else{
            System.out.println("Không tìm thấy ký tự trong chuỗi");
        }
    }
}
