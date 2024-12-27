package leadCode;

import java.util.Arrays;

public class Madian_of_Two_Sorted_Array {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int[] merge=new int[nums1.length+nums2.length];
       int k=0;

       for(int i=0;i<nums1.length;i++){
           merge[k++]=nums1[i];
       }
       for(int i=0;i<nums2.length;i++){
           merge[k++]=nums2[i];
       }


     Arrays.sort(merge);
       int n=merge.length;
       if(n%2==1){
           return merge[n/2];
       }

       else{
           int middle1=merge[n/2-1];
           int middle2=merge[n/2];
           return (middle1+middle2)/2.0;
       }

    }

    public static void main(String[] args) {
        int[] num1={32,31,53,12,54};
        int[] num2={32,54,23,234,5,312};

        System.out.println(findMedianSortedArrays(num1,num2));
    }
}
