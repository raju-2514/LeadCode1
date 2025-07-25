package July;

import java.util.Arrays;

public class FindMInimuminRotatedSortsArrray {
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // If the array is not rotated (already sorted)
        if (nums[left] < nums[right]) {
            return nums[left];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than the right, the min is in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // The min is in the left half including mid
                right = mid;
            }
        }

        // After the loop, left == right pointing to the smallest element
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 4, 5, 1, 2};
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums3 = {11, 13, 15, 17};

        System.out.println("Minimum in nums1: " + findMin(nums1)); // Output: 1
        System.out.println("Minimum in nums2: " + findMin(nums2)); // Output: 0
        System.out.println("Minimum in nums3: " + findMin(nums3)); // Output: 11
    }
}
