package Basic;

import java.util.ArrayList;
import java.util.List;

public class First {
    public static void main(String[] args) {
        List<String> sr=new ArrayList<>();
        sr.add("Raju");
        sr.add("Dola");
        sr.add("Jesmin");

        for(String s: sr){
            System.out.println(s);
        }
    }
}
