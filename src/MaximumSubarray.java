package February;

public class MaximumSubarray {
    public int MaxSubarray(int[] nums){
        int maxsum=nums[0];
        int currentsum=nums[0];

        for(int i=1;i<nums.length;i++){
            currentsum=Math.max(nums[i],currentsum+nums[i]);
            maxsum=Math.max(maxsum,currentsum);
        }

    return maxsum;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSubarray().MaxSubarray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
