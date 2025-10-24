package October;

import java.util.ArrayList;
import java.util.List;

public class CombinationofSumII {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> current, int k, int n, int start) {
        // Base case: if we used k numbers and the sum is n
        if (current.size() == k && n == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // If sum exceeds n or used too many numbers, stop exploring
        if (n < 0 || current.size() > k) return;

        for (int i = start; i <= 9; i++) {
            current.add(i);
            backtrack(result, current, k, n - i, i + 1); // move to next number
            current.remove(current.size() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));  // [[1, 2, 4]]
        System.out.println(combinationSum3(3, 9));  // [[1, 2, 6], [1, 3, 5], [2, 3, 4]]
        System.out.println(combinationSum3(4, 1));  // []
    }
}
