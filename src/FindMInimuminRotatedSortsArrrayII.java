package July;

public class FindMInimuminRotatedSortsArrrayII {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum must be in the right part
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                // Minimum is in the left part including mid
                right = mid;
            } else {
                // nums[mid] == nums[right], can't decide, reduce right
                right--;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        FindMInimuminRotatedSortsArrrayII solver = new FindMInimuminRotatedSortsArrrayII();
        System.out.println(solver.findMin(new int[]{1, 3, 5}));        // Output: 1
        System.out.println(solver.findMin(new int[]{2, 2, 2, 0, 1}));  // Output: 0
        System.out.println(solver.findMin(new int[]{4, 5, 6, 7, 0, 1, 4})); // Output: 0
    }
}
