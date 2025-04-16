package April.Binary_Tree_inOrder_Traversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inorderHelper(node.left, result);     // Visit left subtree
        result.add(node.val);                // Visit node
        inorderHelper(node.right, result);   // Visit right subtree
    }

    public void main(String[] args) {
        Solution.TreeNode root = new Solution.TreeNode(1);
        root.right = new Solution.TreeNode(2);
        root.right.left = new Solution.TreeNode(3);

        Solution solver = new Solution();
        System.out.println(solver.inorderTraversal(root));  // Output: [1, 3, 2]
    }

}

