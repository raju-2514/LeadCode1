package December.CountCompleteTreeNode;

public class CountCompleteTreeNodeSolution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        // If heights are same → it's a perfect tree
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;  // 2^h - 1
        }

        // Otherwise recursively count
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getLeftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    private int getRightHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }
}
