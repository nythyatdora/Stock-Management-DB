import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonMethodImplementation implements CommonMethodStructure {

    public void printlnStringsImp(String[] arr) {
        for (String str : arr) {
            System.out.println(str);
        }
    }

    @Override
    public String formalDateFormat() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
