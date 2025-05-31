package May;

public class LogestConsecutiveSequenc {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i + 1 < nums.length && nums[i + 1] == nums[j]) {
                    count++;
                }
            }
        }
        return count-1;
    }

    public static void main(String[] args) {
        LogestConsecutiveSequenc solution = new LogestConsecutiveSequenc();

        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println(solution.longestConsecutive(nums1));

        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Longest consecutive sequence: " + solution.longestConsecutive(nums2)); // Output: 9
    }
}

