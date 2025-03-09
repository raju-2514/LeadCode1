package March;

public class SortColor {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) { // Swap with low pointer and move both forward
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) { // Leave 1s in place and just move mid forward
                mid++;
            } else { // Swap with high pointer and move high backward
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}