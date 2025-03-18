package March.RemoveDuplicateFromSortedListII;

public class Remove_Duplicate_From_Sorted_List {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next; // Skip duplicate node
            } else {
                current = current.next; // Move to next node
            }
        }
        return head;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        System.out.println("Original List:");
        printList(head);

        head = deleteDuplicates(head);
        System.out.println("List after removing duplicates:");
        printList(head);
    }
}
