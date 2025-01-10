package January;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum_3 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to make it easier to avoid duplicates and use two-pointer approach

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for the second element
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // Skip duplicates for the third element
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Move left pointer to increase the sum
                } else {
                    right--; // Move right pointer to decrease the sum
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {0, 1, 1};
        int[] nums3 = {0, 0, 0};

        System.out.println(threeSum(nums1)); // Output: [[-1, -1, 2], [-1, 0, 1]]
        System.out.println(threeSum(nums2)); // Output: []
        System.out.println(threeSum(nums3)); // Output: [[0, 0, 0]]
    }
}