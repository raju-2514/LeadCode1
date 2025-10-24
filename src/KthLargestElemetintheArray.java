package October;

import java.util.Arrays;

public class KthLargestElemetintheArray {
    public static int findKthLargest(int[] arr,int k){
        Arrays.sort(arr);
        int n=arr.length;

        return arr[n-k];

    }

    public static void main(String[] args) {
        int[] arr={3,2,3,1,2,4,5,5,6};
        int k=4;

        System.out.println(findKthLargest(arr,k));
    }
}
