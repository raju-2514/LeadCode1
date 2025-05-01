package April.ConstructBinaryTreeFromInorderAndPreorder;

import java.util.*;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return build(preorder, inorderIndexMap, 0, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, Map<Integer, Integer> inMap,
                           int preRootIndex, int inLeft, int inRight) {
        if (inLeft > inRight) return null;

        TreeNode root = new TreeNode(preorder[preRootIndex]);
        int inRootIndex = inMap.get(preorder[preRootIndex]);

        int leftTreeSize = inRootIndex - inLeft;

        root.left = build(preorder, inMap, preRootIndex + 1, inLeft, inRootIndex - 1);
        root.right = build(preorder, inMap, preRootIndex + leftTreeSize + 1, inRootIndex + 1, inRight);

        return root;
    }

    // Function to return level-order traversal with 'null' for missing children
    public List<String> treeToList(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                result.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                result.add("null");
            }
        }

        // Remove trailing "null"s
        int i = result.size() - 1;
        while (i >= 0 && result.get(i).equals("null")) {
            result.remove(i--);
        }

        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1 = {9, 3, 15, 20, 7};
        TreeNode tree1 = sol.buildTree(preorder1, inorder1);
        System.out.println("Output: " + sol.treeToList(tree1));  // Output: [3, 9, 20, null, null, 15, 7]

        // Example 2
        int[] preorder2 = {-1};
        int[] inorder2 = {-1};
        TreeNode tree2 = sol.buildTree(preorder2, inorder2);
        System.out.println("Output: " + sol.treeToList(tree2));  // Output: [-1]
    }
}
