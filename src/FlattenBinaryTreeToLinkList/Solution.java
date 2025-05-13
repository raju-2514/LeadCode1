package May.FlattenBinaryTreeToLinkList;

public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;

        // Recursively flatten left and right subtrees
        flatten(root.left);
        flatten(root.right);

        // Store the left and right subtrees
        TreeNode left = root.left;
        TreeNode right = root.right;

        // Set left to null and right to the flattened left subtree
        root.left = null;
        root.right = left;

        // Find the end of the new right subtree and attach the original right subtree
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }

        current.right = right;
    }
}
