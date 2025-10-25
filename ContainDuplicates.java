package October;

import java.util.HashSet;
import java.util.Set;

public class ContainDuplicates {

    public static boolean findDuplicateValue(int[] nums){

        Set<Integer> seen=new HashSet<>();
        for(int num: nums){
            if(seen.contains(num)){
                return true;
            }

           seen.add(num);
        }

        return false;

    }


    public static void main(String[] args) {

        int[] arr={1,2,3,1};
        System.out.println(findDuplicateValue(arr));
    }
}
