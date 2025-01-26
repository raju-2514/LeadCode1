public class Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Target found
            } else if (nums[mid] < target) {
                left = mid + 1; // Move right
            } else {
                right = mid - 1; // Move left
            }
        }

        return left; // Position where the target would be inserted
    }

    public static void main(String[] args) {
        Search_Insert_Position search = new Search_Insert_Position();
        System.out.println(search.searchInsert(new int[]{1,3,5,6}, 5));
    }
}
