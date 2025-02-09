package February;

public class JumpGameII {
    public static int jump(int[] nums) {
        int jumps = 0, farthest = 0, end = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == end) {
                jumps++;
                end = farthest;
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4})); // Output: 2
        System.out.println(jump(new int[]{2, 3, 0, 1, 4})); // Output: 2
    }
}
