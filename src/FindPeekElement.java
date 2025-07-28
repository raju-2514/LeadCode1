package July;

import java.util.ArrayList;
import java.util.Collections;

public class FindPeekElement {
    public static int findPeek(int[] nums){
        ArrayList<Integer> val = new ArrayList<Integer>();

        for(int i=0;i<nums.length-1;i++){
            val.add(nums[i]);
        }

        if(nums==null) return 0;
        Collections.sort(val);
        System.out.println();
//        for(int i=0;i<=nums.length;i++){
//            if(nums[i]>nums[i+1] && nums[i]>nums[i-1]){
//                return nums
//            }

//        }

        return val.getLast()-1;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        int[] num1={1,2,1,3,5,6,4};
        System.out.println(findPeek(nums));
        System.out.println(findPeek(num1));
    }
}
