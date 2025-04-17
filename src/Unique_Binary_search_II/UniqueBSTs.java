package April.Unique_Binary_search_II;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UniqueBSTs {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // Pick i as root from start to end
        for (int i = start; i <= end; i++) {
            // All possible left subtrees if i is chosen as root
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            // All possible right subtrees if i is chosen as root
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            // Connect left and right trees to root i
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    allTrees.add(root);
                }
            }
        }
        return allTrees;
    }

    // Helper method to convert BSTs into List format
    public List<List<Integer>> serializeTrees(List<TreeNode> trees) {
        List<List<Integer>> result = new ArrayList<>();
        for (TreeNode root : trees) {
            result.add(serialize(root));
        }
        return result;
    }

    // Level order serialization (nulls included)
    private List<Integer> serialize(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                result.add(node.val);
                q.add(node.left);
                q.add(node.right);
            } else {
                result.add(null);
            }
        }

        // Trim trailing nulls
        int i = result.size() - 1;
        while (i >= 0 && result.get(i) == null) {
            result.remove(i--);
        }
        return result;
    }

    // Test
    public static void main(String[] args) {
        UniqueBSTs sol = new UniqueBSTs();
        int n = 3;
        List<TreeNode> trees = sol.generateTrees(n);
        List<List<Integer>> serialized = sol.serializeTrees(trees);

        for (List<Integer> tree : serialized) {
            System.out.println(tree);
        }
    }
}
