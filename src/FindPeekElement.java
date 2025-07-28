package July;
public class FindPeekElement {
    public static int findPeek(int[] nums){
      int left=0;
      int right= nums.length-1;
      while(left<right){
          int mid=left+(right-left)/2;
          if (nums[mid] > nums[mid+1]) {
              right=mid;
          }
          else{
              left=mid+1;
          }
      }
      return left;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        int[] num1={1,2,1,3,5,6,4};
        System.out.println(findPeek(nums));
        System.out.println(findPeek(num1));
    }
}
