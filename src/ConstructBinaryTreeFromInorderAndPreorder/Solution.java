package April.ConstructBinaryTreeFromInorderAndPreorder;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Integer, Integer> inorderIndexMap;
    private int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        preorderIndex = 0;

        // Build a hashmap to store value -> index relations
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }

        // Select the preorderIndex element as the root and increment it
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Build left and right subtree
        // Exclude inorderIndexMap[rootVal] element because it's the root
        root.left = buildTreeHelper(preorder, left, inorderIndexMap.get(rootVal) - 1);
        root.right = buildTreeHelper(preorder, inorderIndexMap.get(rootVal) + 1, right);

        return root;
    }
}

// For testing purpose
public static void main(String[] args) {
    TreeNode outer = new TreeNode();
    Solution sol = outer.new Solution();

    int[] preorder1 = {3,9,20,15,7};
    int[] inorder1 = {9,3,15,20,7};
    TreeNode root1 = sol.buildTree(preorder1, inorder1);
    printTree(root1);

    System.out.println();

    int[] preorder2 = {-1};
    int[] inorder2 = {-1};
    TreeNode root2 = sol.buildTree(preorder2, inorder2);
    printTree(root2);
}

// Helper function to print the tree (Preorder Traversal)
public static void printTree(TreeNode root) {
    if (root == null) {
        System.out.print("null ");
        return;
    }
    System.out.print(root.val + " ");
    printTree(root.left);
    printTree(root.right);

}