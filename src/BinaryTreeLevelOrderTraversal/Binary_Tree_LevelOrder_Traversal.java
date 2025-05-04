package May.BinaryTreeLevelOrderTraversal;

import April.ConstructBinaryTreeFromInorderAndPreorder.Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_LevelOrder_Traversal {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                currentLevel.add(curr.val);
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }

            // Add at the beginning for bottom-up order
            result.add(0, currentLevel);
        }

        return result;
    }

    // Helper to build a BST from preorder traversal
    int index = 0;
    public TreeNode buildTreeFromPreorder(int[] preorder) {
        return buildBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode buildBST(int[] preorder, int lower, int upper) {
        if (index == preorder.length) return null;
        int val = preorder[index];
        if (val < lower || val > upper) return null;

        index++;
        TreeNode root = new TreeNode(val);
        root.left = buildBST(preorder, lower, val);
        root.right = buildBST(preorder, val, upper);
        return root;
    }

    // Inorder traversal
    public static void printInorder(TreeNode node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }

    // Main method
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};

        Binary_Tree_LevelOrder_Traversal obj = new Binary_Tree_LevelOrder_Traversal();
        TreeNode root = obj.buildTreeFromPreorder(preorder);

        System.out.print("Inorder traversal of constructed tree: ");
        printInorder(root);
        System.out.println();

        List<List<Integer>> levelOrderBottom = obj.levelOrderBottom(root);
        System.out.println("Bottom-up level order traversal: " + levelOrderBottom);
    }
}