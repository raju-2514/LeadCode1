public class Median_of_Two_sorted_Array {
    public static double FindMedianofTwoSortedArray(int[] array1,int[] array2){
        double sum1=0;
        double sum2=0;
        for(int i=0;i<array1.length;i++){
            sum1+=array1[i];
        }
        for(int j=0;j<array2.length;j++){
            sum2+=array2[j];
        }

        return (sum1+sum2)/(array1.length+array2.length);
    }
    public static void main(String[] args) {
      int[] array1=new int[]{1,2,3,4,5};
      int[] array2=new int[]{4,5,1,2};

      System.out.println(FindMedianofTwoSortedArray(array1,array2));
    }
}
