package August.BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                // add children for next level
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
                // if it's the last node in this level, add to view
                if (i == size - 1) {
                    result.add(current.val);
                }
            }
        }
        return result;
    }
}
