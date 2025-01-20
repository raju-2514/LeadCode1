package January;

public class Remove_Element {
    public static int removeElement(int[] nums, int val) {
        int k = 0; // number of elements not equal to val
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        Remove_Element obj = new Remove_Element();
        System.out.println(obj.removeElement(new int[]{1, 2, 3, 4, 5}, 3));
        
    }
}
