package August.ReverseLinkList;

public class reverseNode {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next; // save next node
            curr.next = prev;              // reverse pointer
            prev = curr;                   // move prev forward
            curr = nextNode;               // move curr forward
        }
        return prev; // new head
    }

    // Helper to print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example 1: [1,2,3,4,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original: ");
        printList(head);

        ListNode reversed = reverseList(head);
        System.out.print("Reversed: ");
        printList(reversed);
    }
}
