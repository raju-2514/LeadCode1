package May;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    public static List<Integer> getRow(int rowIndex) {
     List<Integer> result=new ArrayList<>();
     long value=1;

     for(int i=0;i<=rowIndex;i++){
         result.add((int)value);

         value=value*(rowIndex-i)/(i+1);
     }
     return result;

    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
}
