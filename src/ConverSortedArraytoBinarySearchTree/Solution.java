package May.ConverSortedArraytoBinarySearchTree;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // Choose middle element to ensure balanced tree
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        // Recursively build the left and right subtrees
        node.left = buildBST(nums, left, mid - 1);
        node.right = buildBST(nums, mid + 1, right);

        return node;
    }

    // Optional: Helper method to print tree in pre-order for testing
    public void printPreOrder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution converter = new Solution();
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = converter.sortedArrayToBST(nums);

        // Print the tree in pre-order traversal
        converter.printPreOrder(root);
    }
}
