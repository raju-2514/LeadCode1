package January;

import java.util.ArrayList;
import java.util.List;

public class MejorityElementsII {
    public static List<Integer> mejorityElements(int[] nums){
    List<Integer> list=new ArrayList<>();
    if(nums.length==0 || nums==null) return list;
    int n=nums.length;

    int count1=0,count2=0;
    int candidate1=0,candidate2=0;

    for(int num: nums){
        if(num==candidate1){count1++;}
        else if (num==candidate2) {count2++;}
        else if (count1==0) {count1=1;candidate1=num;}
        else if(count2==0){count2=1;candidate2=num;}
        else {count1--;count2--;}

    }
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        if (count1 > n / 3) list.add(candidate1);
        if (count2 > n / 3) list.add(candidate2);

    return list;
    }
    public static void main(String[] args) {

    }
}
