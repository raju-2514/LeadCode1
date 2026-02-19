package February.PalindromLinkedList;

import java.util.ArrayList;

public class linkList {

    public static boolean isPalindrome(TreeNode head){
        ArrayList<Integer> list=new ArrayList<>();

        while(head !=null){
         list.add(head.val);
         head=head.next;
        }


        int i = 0;
        int j = list.size() - 1;

        while(i<j){

            if(!list.get(i).equals(list.get(j))){
                return false ;
            }
            i++;
            j--;
        }

        return true;

    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.next = new TreeNode(2);
        head.next.next = new TreeNode(2);
        head.next.next.next = new TreeNode(1);

        System.out.println(isPalindrome(head));
    }


}
