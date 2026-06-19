package June.BinaryTreePath;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath_Solution {
    public List<String> BinaryTreePath(TreeNode root){
        List<String> result=new ArrayList<>();
        dfs(root,new StringBuilder(),result);
        return result;
    }

    public void dfs(TreeNode node,StringBuilder path, List<String> result){
    if(node ==null){
        return;
    }

    int len=path.length();

    if(len>0){
        path.append("->");
    }
    path.append(node.val);

    if(node.left==null && node.right==null){
        result.add(path.toString());
    }
    else{
    dfs(node.left,path, result);
    dfs(node.right,path,result);
        }


    path.setLength(len);
    }
}
