package August;

import java.util.HashMap;
import java.util.Stack;

public class IsomorphicString {
    public static boolean isomorphic(String s,String t){

        if(s.isEmpty() || t.isEmpty()){return false;}

        HashMap<Character,Character> mapST=new HashMap<>();
        HashMap<Character,Character> mapTS=new HashMap<>();

        for(int i=0;i<s.length();i++){
            char c1=s.charAt(i);
            char c2=t.charAt(i);

            if (mapST.containsKey(c1)) {
                if(mapST.get(c1)!=c2){
                    return false;
                }
            }
            else {
                mapST.put(c1,c2);
            }

            if (mapTS.containsKey(c2)){
                if(mapTS.get(c2) !=c1){return false;}
            }
            else {
                mapTS.put(c2,c1);
            }
            }

        return true;
        }

    public static void main(String[] args) {
        System.out.println(isomorphic("egg", "add"));
        System.out.println(isomorphic("foo", "bar"));
        System.out.println(isomorphic("paper", "title"));

    }

    }




