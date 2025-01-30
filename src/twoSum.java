package February;

import java.util.Arrays;

public class twoSum {

    public  int[] twoSum(int[] nums, int target) {
        if(nums.length == 0)
        {
            return new int[0];
        }
        if(nums.length !=0);
        {
            for(int i = 0; i < nums.length; i++) {
                for(int j = i+1; j < nums.length; j++) {
                    if(nums[i] + nums[j] == target) {
                        return new int[] {i, j};
                    }
                }
            }
            }
            return new int[0];
        }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new twoSum().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    }



