package August;

public class MajorityElement {
    public static int calculateMajorityElements(int[] num) {
        int n = num.length;
        int count = 0;
        int maxvalue=0;
        for (int i = 0; i < n; i++) {
         for(int j=1;j<n;j++){
             if(num[i]==num[j]){
                 count++;
             }
         }

            maxvalue=Math.max(maxvalue,count);
        }
        return maxvalue;

    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 3};
        int[] arr2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(calculateMajorityElements(arr));
        System.out.println(calculateMajorityElements(arr2));
    }
}
