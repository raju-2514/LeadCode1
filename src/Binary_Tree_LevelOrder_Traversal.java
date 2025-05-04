package May.BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_LevelOrder_Traversal {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (result == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> currentLevel = new ArrayList<>();
            while(size>0){
                TreeNode curr=q.poll();
                currentLevel.add(curr.val);
                if(curr.left!=null){q.offer(curr.left);}
                if(curr.right!=null){q.offer(curr.right);}
        }
            result.add(currentLevel);
    }
        return result;
}


}
