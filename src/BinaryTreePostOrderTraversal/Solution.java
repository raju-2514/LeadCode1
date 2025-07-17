package July.BinaryTreePostOrderTraversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> postorderTraversal(TreeNode root){
        List<Integer> results=new ArrayList<>();
        postorder(root,results);
        return results;
    }

    public static void  postorder(TreeNode node,List<Integer> results){
        if(node==null) return;
        postorder(node.left,results);
        postorder(node.right,results);
        results.add(node.val);

    }

    public static void main(String[] args) {
     TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        Solution pt = new Solution();
        List<Integer> output = pt.postorderTraversal(root);

        System.out.println(output);
    }
}
