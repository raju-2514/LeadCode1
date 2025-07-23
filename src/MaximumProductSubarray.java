package July;

public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int maxProduct = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = currMax;

            currMax = Math.max(nums[i], Math.max(currMax * nums[i], currMin * nums[i]));
            currMin = Math.min(nums[i], Math.min(temp * nums[i], currMin * nums[i]));

            maxProduct = Math.max(maxProduct, currMax);
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, -2, 4};
        int[] nums2 = {-2, 0, -1};

        System.out.println("Max product of nums1: " + maxProduct(nums1)); // Output: 6
        System.out.println("Max product of nums2: " + maxProduct(nums2)); // Output: 0
    }
}
