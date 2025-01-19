package January;

public class Remove_Duplicate_Value_From_The_Sorted_Array {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int k = 1;

        for (int i = 1; i < nums.length; i++)
        { if (nums[i] != nums[i - 1])
        { nums[k] = nums[i]; k++; } }
        return k;


    }
    public static void main(String[] args) {
     Remove_Duplicate_Value_From_The_Sorted_Array obj = new Remove_Duplicate_Value_From_The_Sorted_Array();
        int[] nums1 = {1, 1, 2};
        int k1 = Remove_Duplicate_Value_From_The_Sorted_Array.removeDuplicates(nums1);
        System.out.println("Unique count: " + k1); // Output: 2
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + " "); // Output: 1 2
        }


    }
}
