package August;

public class BitwiseANDofNumberRange {
    public static int rangeBitwiseAnd(int left, int right) {
          int shift =0;

          while(left<right){
              left>>=1;
              right>>=1;

              shift++;
          }
        return left<<shift;
    }

    public static void main(String[] args) {
        int a=15;
        int b=48;
        System.out.println(rangeBitwiseAnd(a,b));
    }
}
