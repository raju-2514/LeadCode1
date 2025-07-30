package July;

import java.sql.SQLOutput;

public class CompareVersionsNumberss {
    public static int compareVersion(String version1,String version2){
        String[] a=version1.split("\\.");
        String[] b=version2.split("\\.");

        int maxLength=Math.max(a.length,b.length);
        for(int i=0;i<maxLength;i++){
            int v1 = (i < a.length) ? Integer.parseInt(a[i]) : 0;
            int v2 = (i < b.length) ? Integer.parseInt(b[i]) : 0;

            if (v1 < v2) return -1;
            if (v1 > v2) return 1;

        }
        return 0;

    }

    public static void main(String[] args) {

        String s1="1.2";
        String s2="1.10";
        System.out.println(compareVersion(s1,s2));
    }
}
