package May;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleMinimumPath {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // Create an array to store the minimum path sums
        int[] dp = new int[n];

        // Initialize dp with the last row of the triangle
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        // Bottom-up calculation
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
            }
        }

        // The top element contains the minimum path sum
        return dp[0];
    }
    public static void main(String[] args) {
        TriangleMinimumPath solution = new TriangleMinimumPath();

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        System.out.println("Minimum path sum: " + solution.minimumTotal(triangle)); // Output: 11
    }
}
