package March;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static  List<List<Integer>> subsets(int[] nums){
      List<List<Integer>> result=new ArrayList<>();
      result.add(new ArrayList<>());

      for(int num:nums){
          int size=result.size();
          for(int i=0;i<size;i++){
              List<Integer> newSubset=new ArrayList<>(result.get(i));
              newSubset.add(num);
              result.add(newSubset);
          }

      }
      return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
}
