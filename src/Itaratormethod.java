package June.HASHMAP;

import java.util.ArrayList;
import java.util.Iterator;

public class Itaratormethod {
    public static void main(String[] args) {
        ArrayList<String> arr=new ArrayList<>();
        arr.add("Raju");
        arr.add("Biswas");
        arr.add("Name");
        arr.add("Md");
        Iterator<String> it=arr.iterator();

     
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}
