package July;

public class UnglyNumber {
    public static boolean findUnglyNumber(int n){
        if (n <= 0) return false;

        int[] factors = {2, 3, 5};

        for (int f : factors) {
            while (n % f == 0) {
                n /= f;
            }
        }

        return n == 1;

    }

    public static void main(String[] args) {
        int n=5;
        System.out.println(findUnglyNumber(n));
    }
}
