package April.Recovery_Binary_Search_Tree;

public class Solution {

    private TreeNode first=null;
    private TreeNode second=null;


    private TreeNode prev=new TreeNode(Integer.MIN_VALUE);



    public void recoverTree(TreeNode root){
        inOrder(root);

       int temp=first.val;
       first.val=second.val;
       second.val=temp;

    }

    public void inOrder(TreeNode root){
         if(root==null){return;}

         inOrder(root.left);

         if(root !=null && root.val<prev.val){
             if(first==null){
                 first=prev;

             }
              second=root;

         }
         prev=root;

          inOrder(root.right);
    }


    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        System.out.println("Before recovery (in-order):");
        printInOrder(root);
        System.out.println();

        Solution solution = new Solution();
        solution.recoverTree(root);

        System.out.println("After recovery (in-order):");
        printInOrder(root);
        System.out.println();
    }
    }

