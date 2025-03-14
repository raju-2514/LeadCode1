package March;

public class Remove_Duplicate_from_The_Array {
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length; // If <= 2 elements, return as is

        int k = 2; // Start from index 2 since first two elements are always valid

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) { // Ensure at most two occurrences
                nums[k] = nums[i];
                k++;
            }
        }

        return k; // Return the length of the modified array
    }

    public static void main(String[] args) {
        int[] arr={1,1,1,2,2,3,4,5};
        System.out.println(removeDuplicates(arr));
    }
}
