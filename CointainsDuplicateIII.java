package November;

import java.util.TreeSet;

public class CointainsDuplicateIII {
    public static boolean containsAlostNearByDuplicates(int[] nums,int indexDiff,int valueDiff){
        TreeSet<Long> set=new TreeSet<>();


        for(int i=0;i<nums.length;i++){
            long current =nums[i];

            Long near=set.ceiling(current-valueDiff);

            if(near != null && near<=(current+valueDiff)){
                return true;
            }

            set.add(current);
            // Keep window size valid
            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }

        return false;

    }
    public static void main(String[] args) {
        CointainsDuplicateIII s = new CointainsDuplicateIII();

        int[] nums1 = {1, 2, 3, 1};
        System.out.println(s.containsAlostNearByDuplicates(nums1, 3, 0)); // true

        int[] nums2 = {1, 5, 9, 1, 5, 9};
        System.out.println(s.containsAlostNearByDuplicates(nums2, 2, 3)); // false
    }
}
