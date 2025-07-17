package July.InsertionSortList;

public class SortedLinkList {
    public static ListNode insertionSortList(ListNode head) {
      ListNode dummy=new ListNode(-1);
      ListNode current=head;

      while(current!=null){

          ListNode tem=current.next;
          ListNode pre=dummy;
          ListNode nxt=dummy.next;

          while(nxt!=null){
              if(nxt.val>current.val){
                  break;
              }
              else{
                  pre=nxt;
                  nxt=nxt.next;

              }
          }
          current.next=current.next;
          pre.next=nxt;
          current=dummy;

      }

      return dummy.next;
    }
}
