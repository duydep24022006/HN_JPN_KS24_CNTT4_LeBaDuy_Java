package SS6.bai1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main {
    public static void main(String[] args) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


            Student sv1 = new Student(
                    "MSV123",
                    "Lê Bá Duy",
                    sdf.parse("24/02/2006"),
                    9.0
            );
            Student sv2 = new Student(
                    "MSV124",
                    "Nguyễn Văn A",
                    sdf.parse("10/01/2005"),
                    8.2
            );

            sv1.renderStudent();
            sv2.renderStudent();
        } catch (ParseException e) {
            System.out.println("sai định dạng ngày sinh");
        }

    }
}
