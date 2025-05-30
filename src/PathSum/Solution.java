package May.PathSum;

public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
     if(root==null){return  false;}
        if(root.left==null && root.right==null){
            return root.val==targetSum;
        }

        int remaaingSum=targetSum-root.val;

        return hasPathSum(root.left,remaaingSum) && hasPathSum(root.right,remaaingSum);
    }

    public static void main(String[] args) {
        // Building the tree: [5,4,8,11,null,13,4,7,2,null,null,null,1]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        Solution ps = new Solution();
        System.out.println("Has path sum 22? " + ps.hasPathSum(root, 22)); // Output: true
    }
}
