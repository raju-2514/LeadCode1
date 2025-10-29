package October;

import java.util.TreeSet;

public class ContainIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            long x = nums[i];

            // Find the smallest number >= x - valueDiff
            Long candidate = set.ceiling(x - valueDiff);

            // Check if candidate <= x + valueDiff
            if (candidate != null && candidate <= x + valueDiff) {
                return true;
            }

            // Add current number
            set.add(x);

            // Keep window size <= indexDiff
            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        containsNearbyAlmostDuplicate obj = new containsNearbyAlmostDuplicate();
        System.out.println(obj.containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3, 0)); // true
        System.out.println(obj.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3)); // false
    }
}
