package July.MAP;

import java.util.TreeMap;

public class TreeMAPCode {

    public static void main(String[] args) {
        TreeMap<String,String> map=new TreeMap<>();
        map.put("1","Raju");
        map.put("2","Raju");
        map.put("3","Raju");
        map.put("5","Raju");
        map.put("6","Raju");

        System.out.println(map);

        //key only
        for(String s:map.keySet()){
            System.out.println(s);
        }
        //values print
        for(String v:map.values()){
            System.out.println(v);
        }

    }
}
