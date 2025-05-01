package April.ConstructBinaryTreeFromInorderAndPreorder;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }
        return splitTree(preorder, inOrderIndexMap, 0, 0, inorder.length - 1);

    }


    private TreeNode splitTree(int[] preorder, Map<Integer, Integer> integerIntegerMap,
                               int rootIndex, int left, int right) {
        TreeNode root = new TreeNode(preorder[rootIndex]);
        int mid = integerIntegerMap.get(preorder[rootIndex]);

        if (mid > left) {
            root.left = splitTree(preorder, integerIntegerMap,
                    rootIndex + 1, left, mid - 1);
        }

        if (mid < right) {
            root.right = splitTree(preorder, integerIntegerMap, rootIndex + mid - left + 1,
                    mid - 1, right);
        }
        return root;

    }

    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }


    public static void main(String[] args) {
        // Sample input
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};


        Solution treeBuilder = new Solution();
        TreeNode root = treeBuilder.buildTree(preorder, inorder);

        // Print the tree in inorder to verify
        System.out.print("Inorder traversal of constructed tree: ");
        printInorder(root);

    }
}
