package May.PopulationgNextRightPointer;

public class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.left.next;
            }

            connect(root.left);
            connect(root.right);
        }

        return root;

    }
}
