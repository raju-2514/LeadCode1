package July;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumGap {
    public static int findMinimumGap(int[] nums){
//        if (nums.length < 2) return 0; // Gap can't be computed
//
//        Arrays.sort(nums); // Sort the array first
//
//        int minGap = Integer.MAX_VALUE;
//
//        for (int i = 1; i < nums.length; i++) {
//            int gap = nums[i] - nums[i - 1];
//            if (gap < minGap) {
//                minGap = gap;
//            }
//        }
//
//        return minGap;
        if (nums == null || nums.length < 2) return 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (min == max) return 0;

        int n = nums.length;
        int bucketSize = Math.max(1, (max - min) / (n - 1));
        int bucketCount = (max - min) / bucketSize + 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        boolean[] used = new boolean[bucketCount];

        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        // Fill the buckets
        for (int num : nums) {
            int index = (num - min) / bucketSize;
            bucketMin[index] = Math.min(bucketMin[index], num);
            bucketMax[index] = Math.max(bucketMax[index], num);
            used[index] = true;
        }

        // Compute the max gap
        int maxGap = 0;
        int prevMax = min;

        for (int i = 0; i < bucketCount; i++) {
            if (!used[i]) continue;

            maxGap = Math.max(maxGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }

        return maxGap;
    }

    public static void main(String[] args) {
        int[] nums={3,6,9,1};
        int[] nums1={10};

        System.out.println(findMinimumGap(nums));
        System.out.println(findMinimumGap(nums1));
    }
}
