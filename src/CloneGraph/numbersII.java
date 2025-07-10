package July.CloneGraph;

public class numbersII {
    public static int singleNUmber(int[] nums){

      int ones=0;
      int twos=0;
      for(int num: nums ){
          ones = (ones ^ num) & ~twos;
          twos = (twos ^ num) & ~ones;
      }
        return ones;

    }

    public static void main(String[] args) {
        int[] nums={1,0,1,0,1,0,99};
        System.out.println(singleNUmber(nums));
    }
}
