package February;

import java.util.Arrays;

public class ValidAnagram {
    public static boolean anagramCheck(String s, String t){
        if(s.length() != t.length()) return false;

      char[] arr1=s.toCharArray();
      char[] arr2=t.toCharArray();

        Arrays.sort(arr2);
        Arrays.sort(arr1);

        return Arrays.equals(arr1,arr2);
    }



}
