package January;

public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // Move the first pointer n + 1 steps ahead to create a gap of n between first and second
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move both pointers until first reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Remove the nth node
        second.next = second.next.next;

        return dummy.next;
    }

    // Helper method to print the list (for testing purposes)
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Example usage
    public static void main(String[] args) {
        RemoveNthNode solution = new RemoveNthNode();

        // Example 1
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.print("Original list: ");
        solution.printList(head1);
        head1 = solution.removeNthFromEnd(head1, 2);
        System.out.print("After removal: ");
        solution.printList(head1);

        // Example 2
        ListNode head2 = new ListNode(1);
        System.out.print("Original list: ");
        solution.printList(head2);
        head2 = solution.removeNthFromEnd(head2, 1);
        System.out.print("After removal: ");
        solution.printList(head2);

        // Example 3
        ListNode head3 = new ListNode(1, new ListNode(2));
        System.out.print("Original list: ");
        solution.printList(head3);
        head3 = solution.removeNthFromEnd(head3, 1);
        System.out.print("After removal: ");
        solution.printList(head3);
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
