package January.ReverseNode;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        // Dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;
        ListNode current = head;

        while (true) {
            // Check if there are k nodes left to reverse
            ListNode groupStart = current;
            int count = 0;
            while (current != null && count < k) {
                current = current.next;
                count++;
            }

            if (count < k) {
                // Not enough nodes left to reverse
                break;
            }

            // Reverse k nodes
            ListNode prev = null;
            ListNode next = null;
            ListNode node = groupStart;
            for (int i = 0; i < k; i++) {
                next = node.next;
                node.next = prev;
                prev = node;
                node = next;
            }

            // Connect the reversed group with the previous and next parts of the list
            prevGroupEnd.next = prev;
            groupStart.next = current;

            // Move prevGroupEnd to the end of the reversed group
            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }

    // Utility method to create a linked list from an array
    public static ListNode createLinkedList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummy.next;
    }

    // Utility method to print a linked list
    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ReverseKGroup solution = new ReverseKGroup();

        int[] values1 = {1, 2, 3, 4, 5};
        int k1 = 2;
        ListNode head1 = createLinkedList(values1);
        ListNode result1 = solution.reverseKGroup(head1, k1);
        printLinkedList(result1);

        int[] values2 = {1, 2, 3, 4, 5};
        int k2 = 3;
        ListNode head2 = createLinkedList(values2);
        ListNode result2 = solution.reverseKGroup(head2, k2);
        printLinkedList(result2);
    }
}
