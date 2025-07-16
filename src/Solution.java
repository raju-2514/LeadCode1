package July.BinaryTreePreORderTraversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return null;
        List<Integer> result = new ArrayList<>();
        preorder(root,result);
        return result;
    }

    public static void preorder(TreeNode node, List<Integer> result){
       if(node==null) return;
       result.add(node.val);
       preorder(node.left,result);
       preorder(node.right,result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        Solution pt = new Solution();
        List<Integer> output = pt.preorderTraversal(root);

        System.out.println(output);
    }
}
