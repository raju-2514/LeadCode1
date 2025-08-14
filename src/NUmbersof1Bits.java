package August;

public class NUmbersof1Bits {
    public static int hammingWeight(int n){
        int count=0;
       while(n !=0){
           count+=(n & 1);
           n>>>=1;
       }
       return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
        System.out.println(hammingWeight(128));
    }
}
