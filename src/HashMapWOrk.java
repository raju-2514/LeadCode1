package Basic;

import java.util.HashMap;

public class HashMapWOrk {


    public static void main(String[] args) {
        HashMap<String,String> CapitalCities=new HashMap<>();
        CapitalCities.put("Bangladesh","Dhaka");
        CapitalCities.put("India","Delhi");
        CapitalCities.put("Pakisthan","Islamabad");
        CapitalCities.put("Nepal","Catmundu");

        System.out.println(CapitalCities);
        System.out.println(CapitalCities.get("Bangladesh"));

    }
}
