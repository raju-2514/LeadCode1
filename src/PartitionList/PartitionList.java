package March.PartitionList;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0); // Dummy node for the 'before' list
        ListNode before = beforeHead;
        ListNode afterHead = new ListNode(0);  // Dummy node for the 'after' list
        ListNode after = afterHead;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        after.next = null; // Ensure the last node of the 'after' list does not link to old nodes
        before.next = afterHead.next; // Connect the 'before' list with the 'after' list

        return beforeHead.next; // Return the start of the modified list
    }

    // Helper function to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        PartitionList solution = new PartitionList();
        ListNode newHead = solution.partition(head, 3);
        printList(newHead);
    }
}
