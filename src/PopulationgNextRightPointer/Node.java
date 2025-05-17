package May.PopulationgNextRightPointer;

public class Node {
    int val;
    Node left;
    Node right;
    Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node right, Node left, Node next) {
        this.val = val;
        this.right = right;
        this.left = left;
        this.next = next;
    }
}
