package January;

public class MergeSortedLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Traverse both lists
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Attach the remaining nodes of list1 or list2
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // Return the merged list, skipping the dummy node
        return dummy.next;
    }

    // Helper method to create a linked list from an array
    public static ListNode createList(int[] arr) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return head.next;
    }

    // Helper method to print a linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1, 3, 4};
        ListNode list1 = createList(arr1);
        ListNode list2 = createList(arr2);
        ListNode mergedList = mergeTwoLists(list1, list2);
        printList(mergedList);

        // Test case 2
        list1 = createList(new int[]{});
        list2 = createList(new int[]{});
        mergedList = mergeTwoLists(list1, list2);
        printList(mergedList);

        // Test case 3
        list1 = createList(new int[]{});
        list2 = createList(new int[]{0});
        mergedList = mergeTwoLists(list1, list2);
        printList(mergedList);
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

