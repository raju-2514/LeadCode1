package March;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k){
            List<List<Integer>> result=new ArrayList<>();
            backtrack(result,new ArrayList<>(),1,n,k);
            return result;
    }

    public void backtrack(List<List<Integer>> result,List<Integer> templist,int start,int n,int k ){

        if(templist.size()==k){
            result.add(new ArrayList<>(templist));
            return;
        }

        for (int i = start; i <= n; i++) {
            templist.add(i);
            backtrack(result, templist, i + 1, n, k);
            templist.remove(templist.size() - 1); // backtrack
        }
    }


    public static void main(String[] args) {
        Combinations obj =new Combinations();
        int n=4;
        int k=2;
        System.out.println(obj.combine(n,k));
    }
}
