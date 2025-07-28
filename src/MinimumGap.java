package July;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumGap {
    public static int findMinimumGap(int[] nums){
        if (nums.length < 2) return 0; // Gap can't be computed

        Arrays.sort(nums); // Sort the array first

        int minGap = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            int gap = nums[i] - nums[i - 1];
            if (gap < minGap) {
                minGap = gap;
            }
        }

        return minGap;
    }

    public static void main(String[] args) {
        int[] nums={3,6,9,1};
        int[] nums1={10};

        System.out.println(findMinimumGap(nums));
        System.out.println(findMinimumGap(nums1));
    }
}
