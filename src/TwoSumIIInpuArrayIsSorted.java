package August;

public class TwoSumIIInpuArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                // +1 because it's a 1-indexed array
                return new int[] { left + 1, right + 1 };
            } else if (sum < target) {
                left++;  // Need a larger sum
            } else {
                right--; // Need a smaller sum
            }
        }

        // According to problem statement, there will always be one solution.
        return new int[] { -1, -1 }; // Just a fallback (unreachable case)
    }

    // Example usage
    public static void main(String[] args) {
        TwoSumIIInpuArrayIsSorted solver = new TwoSumIIInpuArrayIsSorted();
        int[] result = solver.twoSum(new int[] {2, 7, 11, 15}, 9);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}
