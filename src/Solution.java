package June.HASHMAP;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {

            HashMap<String, String> map=new HashMap<String,String>();

            map.put("A","B");
            map.put("C","D");
            map.put("E","F");
            map.put("G","H");
            map.put("I","J");
            System.out.println(map);
        for (String i : map.keySet()) {
            System.out.println(i);
        }
    }
}
