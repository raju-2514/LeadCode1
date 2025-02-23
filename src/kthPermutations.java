package February;

import java.util.ArrayList;
import java.util.List;

public class kthPermutations {
    public static String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;

        // Prepare the list of numbers and compute (n-1)! factorial
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            fact *= i;
        }

        // Convert k to zero-based index
        k--;
        StringBuilder result = new StringBuilder();

        for (int i = n; i > 0; i--) {
            fact /= i; // (i-1)! factorial
            int index = k / fact;
            result.append(numbers.get(index));
            numbers.remove(index);
            k %= fact;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3)); // Output: "213"
        System.out.println(getPermutation(4, 9)); // Output: "2314"
        System.out.println(getPermutation(3, 1)); // Output: "123"
    }
}
