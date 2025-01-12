package January;

import java.util.Arrays;

public class Java_Closest {
    public static int threeSumClosest(int[] nums, int target) {
        // Sort the array to use two-pointer technique
        Arrays.sort(nums);
        int closestSum = Integer.MAX_VALUE / 2; // Initialize to a large value

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;

            // Use two-pointer approach to find the closest sum for the current i
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // Update closestSum if the current sum is closer to the target
                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }

                // Adjust pointers based on the comparison between sum and target
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    // If sum equals target, we found the closest sum
                    return sum;
                }
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {-1, 2, 1, -4};
        int target1 = 1;
        System.out.println("Output: " + threeSumClosest(nums1, target1)); // Output: 2

        // Test case 2
        int[] nums2 = {0, 0, 0};
        int target2 = 1;
        System.out.println("Output: " + threeSumClosest(nums2, target2)); // Output: 0
    }

}
