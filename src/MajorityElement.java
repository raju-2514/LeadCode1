package August;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static int calculateMajorityElements(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int majorityCount = nums.length / 2;

        for (int num : nums) {
            int count = countMap.getOrDefault(num, 0) + 1;
            countMap.put(num, count);

            if (count > majorityCount) {
                return num;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 2, 3};
        int[] arr2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(calculateMajorityElements(arr1));
        System.out.println(calculateMajorityElements(arr2));
    }
}
