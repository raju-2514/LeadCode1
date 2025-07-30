package July.InterSectionOfTwoLinkList;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;

        while(headA!=null){
            headA=(headA!=null)? headB:headA.next;
            headB=(headB!=null) ? headA:headB.next;

        }
        return headA;
    }

    public static void main(String[] args) {

    }
}
