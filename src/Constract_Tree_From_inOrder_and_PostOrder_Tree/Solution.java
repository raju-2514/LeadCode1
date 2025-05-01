package April.Constract_Tree_From_inOrder_and_PostOrder_Tree;

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;
        return helper(inorder, postorder, 0, length - 1, 0, length - 1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int inStart,
                            int inEnd, int postStart, int postEnd) {

        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = inStart;
        while (inorder[rootIndex] != rootVal) {
            rootIndex++;
        }

        int leftTreeSize = rootIndex - inStart;

        root.left = helper(inorder, postorder,
                inStart, rootIndex - 1,
                postStart, postStart + leftTreeSize - 1);

        root.right = helper(inorder, postorder,
                rootIndex + 1, inEnd,
                postStart + leftTreeSize, postEnd - 1);

        return root;
    }



    public void printPreorder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    public static void main(String[] args) {
        Solution builder = new Solution();

        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = builder.buildTree(inorder, postorder);

        System.out.println("Preorder traversal of constructed tree:");
        builder.printPreorder(root); // Expected: 3 9 20 15 7
    }
}
