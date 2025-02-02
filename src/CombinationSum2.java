package February;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort to handle duplicates
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            if(i > start && candidates[i] ==candidates[i-1]) continue;
            if (remain<candidates[i]) break;
            tempList.add(candidates[i]);
            backtrack(result, tempList, candidates, remain - candidates[i], i + 1);
            tempList.remove(tempList.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] candidates1 = {10,1,2,7,6,1,5};
        int target1 = 8;
        System.out.println(combinationSum2(candidates1, target1));

        int[] candidates2 = {2,5,2,1,2};
        int target2 = 5;
        System.out.println(combinationSum2(candidates2, target2));
    }
}

