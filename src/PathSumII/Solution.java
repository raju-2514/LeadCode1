package May.PathSumII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void dfs(TreeNode node, int remainingSum, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;

        // Add current node to the path
        path.add(node.val);

        // If it's a leaf and the sum matches, add the path to result
        if (node.left == null && node.right == null && node.val == remainingSum) {
            result.add(new ArrayList<>(path));
        } else {
            // Continue DFS on left and right children
            dfs(node.left, remainingSum - node.val, path, result);
            dfs(node.right, remainingSum - node.val, path, result);
        }

        // Backtrack
        path.remove(path.size() - 1);
    }
}
