package April.SameTree;

public class isSameTree {
    public boolean is_Same_Tree(TreeNode p,TreeNode q){
        if(p==null && q==null) return true;
        if(p!=null || q!=null) return false;
        if(p.val !=q.val) return false;

        return is_Same_Tree(p.left, q.left) && is_Same_Tree(p.right, q.right);
    }

    public static void main(String[] args) {
        // Example 1: p = [1,2,3], q = [1,2,3]
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        isSameTree sol = new isSameTree();
        System.out.println("Are trees same? " + sol.is_Same_Tree(p, q)); // Output: true

        // Example 2: p = [1,2], q = [1,null,2]
        TreeNode p2 = new TreeNode(1);
        p2.left = new TreeNode(2);

        TreeNode q2 = new TreeNode(1);
        q2.right = new TreeNode(2);

        System.out.println("Are trees same? " + sol.is_Same_Tree(p2, q2)); // Output: false
    }
}
