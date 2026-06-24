package June;

import java.util.Arrays;

public class SingleNumber_III {
    public int[] singleNumber(int[]nums){
        int xy=0;
        for(int n: nums){
            xy ^=n;
        }
        xy &= -xy;
        int[] result =new int[2];
        for(int n:nums){
            if((xy & n)==0){
                result[0] ^=n;
            }
            else{
                result[1]^=n;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumber_III ob=new SingleNumber_III();
        int[] arr={1,2,1,3,2,5};

        System.out.println(Arrays.toString(ob.singleNumber(arr)));
    }
}
