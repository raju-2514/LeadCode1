package January;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Longst_common_prefix {

     public static String longst_common_prefix(String[] a) {

        String prefix= a[0];
         if(a.length ==0 || a==null) {
             return "";
         }

         for(int i=0;i<a.length;i++) {

             while(a[i].indexOf(prefix)!=0) {
                 prefix=prefix.substring(0,prefix.length()-1);
                 if(prefix.isEmpty()){
                     return "";
                 }
             }
         }
         return prefix;

     }
    public static void main(String[] args) {

        System.out.println(longst_common_prefix(new String[] { "flower", "flow", "flight" }));
    }
}
