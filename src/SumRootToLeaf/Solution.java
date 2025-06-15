package June.SumRootToLeaf;

public class Solution {
    public int sumNums(Node root) {
        return dfs(root, 0);
    }

    public int dfs(Node node,int current){
        if (node==null){return 0;}
        current=current*10+node.val;

        if(node.left==null && node.right==null){
            return current;
        }
        return dfs(node.left,current)+dfs(node.right,current);
    }


    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(9);
        root.right = new Node(0);
        root.left.left = new Node(5);
        root.left.right = new Node(1);

        Solution sol = new Solution();
        System.out.println(sol.sumNums(root)); // Output: 1026
    }
}
