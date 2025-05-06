package May.ConvertSortLinklistToBinarySearchTree;

public class Solution {
    private ListNode current;

    public TreeNode sortedListToBST(ListNode head) {
        int size = getSize(head);
        current = head;
        return buildBST(0, size - 1);
    }

    private int getSize(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    private TreeNode buildBST(int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;

        // Recursively build the left subtree
        TreeNode left = buildBST(start, mid - 1);

        // Create the root node with current list node
        TreeNode node = new TreeNode(current.val);
        node.left = left;

        // Move the list pointer forward
        current = current.next;

        // Recursively build the right subtree
        node.right = buildBST(mid + 1, end);

        return node;
    }
}
