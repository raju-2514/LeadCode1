package August;

public class ReverseBit {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= (n & 1);
            n >>>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseBit obj = new ReverseBit();

        int n1 = 43261596;
        System.out.println(obj.reverseBits(n1));


        int n2 = 2147483644;
        System.out.println(obj.reverseBits(n2));

    }
}
