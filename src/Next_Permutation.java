package January;

public class Next_Permutation {
    public static void nextPermutation(int[] nums) {
        int n = nums.length;

        // Step 1: Find the first decreasing element from the end
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: If such an element exists, find the element just larger than it to its right
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // Swap elements at indices i and j
            swap(nums, i, j);
        }

        // Step 3: Reverse the elements to the right of index i
        reverse(nums, i + 1, n - 1);
    }

    // Utility method to swap two elements in an array
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Utility method to reverse elements in an array between two indices
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }


    public static void main(String[] args) {

    }

}
