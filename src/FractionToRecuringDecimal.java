package August;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecuringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder result = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) result.append("-");

        long dividend = Math.abs((long) numerator);
        long divisor = Math.abs((long) denominator);

        result.append(dividend / divisor);
        long remainder = dividend % divisor;
        if (remainder == 0) return result.toString();

        result.append(".");
        Map<Long, Integer> map = new HashMap<>();

        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                int start = map.get(remainder);
                result.insert(start, "(");
                result.append(")");
                break;
            }

            map.put(remainder, result.length());

            remainder *= 10;
            result.append(remainder / divisor);
            remainder %= divisor;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        FractionToRecuringDecimal ftd = new FractionToRecuringDecimal();
        System.out.println(ftd.fractionToDecimal(1, 2));
        System.out.println(ftd.fractionToDecimal(2, 1));
        System.out.println(ftd.fractionToDecimal(4, 333));
        System.out.println(ftd.fractionToDecimal(1, 6));
    }
}
