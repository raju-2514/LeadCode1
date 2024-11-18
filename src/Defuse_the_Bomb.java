import java.util.Arrays;

public class Defuse_the_Bomb {
    public static int[] decrypt(int[] code, int k){

        int n=code.length;
        int[] result=new int[n];
        if(k==0){
            Arrays.fill(result, 0);
            return result;
        }
        if (k > 0) {
            // For k > 0, sum the next k elements
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % n]; // Wrap around using modulo
                }
                result[i] = sum;
            }
        } else {
            // For k < 0, sum the previous k elements
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 1; j <= -k; j++) {
                    sum += code[(i - j + n) % n]; // Wrap around using modulo
                }
                result[i] = sum;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] code={5,7,1,4};
        int k=3;
        System.out.println(Arrays.toString(decrypt(code,k)));

    }
}




