package January.SwapNodesInParis;

public class Swap_NodesIn_Paris {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;

            first.next = second.next;
            second.next = first;
            current.next = second;
            current = first;
        }

        return dummy.next;
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
        Swap_NodesIn_Paris solution = new  Swap_NodesIn_Paris();

        // Example 1
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode result1 = solution.swapPairs(head1);
        printList(result1); // Output: 2 1 4 3
    }

}

