package August;

public class RotateArray {
    public  void rotate(int[] nums,int k){
        if (nums == null || nums.length == 0 || k == 0) return;

        int n = nums.length;
        k = k % n; // handle k > n

        int[] arr2 = new int[n - k]; // first part
        int[] arr3 = new int[k];     // second part

        // Fill arr2 with the first n-k elements
        for (int i = 0; i < n - k; i++) {
            arr2[i] = nums[i];
        }

        // Fill arr3 with the last k elements
        for (int i = 0; i < k; i++) {
            arr3[i] = nums[n - k + i];
        }

        // Combine arr3 + arr2 into nums (rotated array)
        int index = 0;
        for (int val : arr3) {
            nums[index++] = val;
        }
        for (int val : arr2) {
            nums[index++] = val;
        }

        // Print rotated array
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        RotateArray obj = new RotateArray();
        obj.rotate(arr, k);
    }
}
