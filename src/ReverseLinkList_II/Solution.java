package April.ReverseLinkList_II;

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 1: Move prev to the node before `left`
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 2: Start reversing the sublist
        ListNode curr = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }

        return dummy.next;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] input = {1, 2, 3, 4, 5};
        ListNode head = sol.arrayToList(input);
        ListNode result = sol.reverseBetween(head, 2, 4);
        int[] output = sol.listToArray(result);
        System.out.println(Arrays.toString(output)); // Output: [1, 4, 3, 2, 5]
    }
}
