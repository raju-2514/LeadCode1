package May.MinimumDepthofBinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size(); // number of nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                // Check if it's a leaf node
                if (current.left == null && current.right == null) {
                    return depth;
                }

                // Add children to the queue
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            depth++;
        }

        return depth; // fallback, though should never reach here
    }
}
