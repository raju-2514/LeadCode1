package July.LinkListCycleII;

public class Solution {
    public static ListNode detectCycle(ListNode head){
        if (head == null || head.next == null) return null;

        ListNode fast = head;
        ListNode slow = head;

        // Use correct condition to avoid NullPointerException
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                // Cycle detected
                fast = head;

                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }

        // No cycle
        return null;

    }
}
