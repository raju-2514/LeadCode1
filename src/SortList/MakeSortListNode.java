package July.SortList;

public class MakeSortListNode {
    public static ListNode sortList(ListNode head){
        if (head == null || head.next == null) return head;

        // Dummy node acts as the sorted list's head
        ListNode dummy = new ListNode(0);
   ListNode curr = head;

        while (curr != null) {
            // At each iteration, insert curr into the sorted part
          ListNode prev = dummy;

            // Find the correct position to insert
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            // Save next node to continue the loop
            ListNode nextTemp = curr.next;

            // Insert current node between prev and prev.next
            curr.next = prev.next;
            prev.next = curr;

            // Move to the next node
            curr = nextTemp;
        }

        return dummy.next;
    }
}
