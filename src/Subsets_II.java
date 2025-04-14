package April;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Sort to handle duplicates
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> tempList, List<List<Integer>> result) {
        result.add(new ArrayList<>(tempList));  // Add current subset to result

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;

            tempList.add(nums[i]);  // Choose
            backtrack(nums, i + 1, tempList, result);  // Explore
            tempList.remove(tempList.size() - 1);  // Unchoose (backtrack)
        }
    }

    // Test case
    public static void main(String[] args) {
        Subsets_II solver = new Subsets_II();

        int[] nums1 = {1, 2, 2};
        System.out.println("Output: " + solver.subsetsWithDup(nums1));

//        int[] nums2 = {0};
//        System.out.println("Output: " + solver.subsetsWithDup(nums2));
    }
}
