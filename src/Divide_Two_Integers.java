package January;

public class Divide_Two_Integers {
    public static int divide(int dividend, int divisor) {
        // Handle edge cases for overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // Overflow case
        }
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }

        // Determine the sign of the result
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Work with positive numbers
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        int quotient = 0;

        // Use bit manipulation to calculate the quotient
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            int multiple = 1;

            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            absDividend -= tempDivisor;
            quotient += multiple;
        }

        // Apply the sign
        return isNegative ? -quotient : quotient;
    }
    public static void main(String[] args) {
        Divide_Two_Integers obj = new Divide_Two_Integers();
        System.out.println(obj.divide(2, 2));

    }
}
