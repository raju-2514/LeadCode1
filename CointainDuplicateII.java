package November;

import java.util.HashMap;

public class CointainDuplicateII {
    public static boolean containNearByDuplicate(int[] nums,int k){
        HashMap<Integer, Integer> map =new HashMap<>();

        for (int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int prevIndex=map.get(nums[i]);
                if(Math.abs(i-prevIndex)<=k){
                    return true;
                }
            }
            map.put(nums[i],i);
        }

        return false;

    }

    public static void main(String[] args) {
      int[] nums={1,2,3,1};
      int k=3;
        System.out.println(containNearByDuplicate(nums,k));
    }
}
