package March;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Traverse from the last digit
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++; // Increment if digit is less than 9
                return digits;
            }
            digits[i] = 0; // Set to 0 if digit is 9
        }

        // If all digits were 9, we need an extra digit at the beginning
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1; // First digit should be 1, rest default to 0
        return newDigits;
    }
    public static void main(String[] args) {
        PlusOne solution = new PlusOne();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1,2,3})));
    }
}
