package December.InvertBinaryTreeConstruction;

public class invertedTree {
    public TreeNode invertTree(TreeNode root) {
        // Base case
        if (root == null) {
            return null;
        }

        // Swap left and right subtrees
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert children
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {

    }
}
