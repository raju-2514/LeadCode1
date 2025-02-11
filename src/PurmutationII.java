package February;

import java.util.ArrayList;
import java.util.List;

public class PurmutationII {
    public static List<List<Integer>> permutationsUnique(int[] nums){
        List<List<Integer>> results=new ArrayList<>();
        backtrack(results,new ArrayList<>(),nums,new boolean[nums.length]);

        return results;

    }

    private static void backtrack(List<List<Integer>> result,List<Integer> tempoList,int[] nums,boolean[] used ){
        if(tempoList.size()==nums.length){
            result.add(new ArrayList<>(tempoList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
            used[i] = true;
            tempoList.add(nums[i]);
            backtrack(result, tempoList, nums, used);
            used[i] = false;
            tempoList.remove(tempoList.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> permutations = permutationsUnique(nums);
        System.out.println(permutations);
    }
}
