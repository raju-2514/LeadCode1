package January;

import java.util.HashMap;

public class Roman_To_Integer {
    public static int romanToInt(String s) {
    // Mapping of Roman symbols to their values
    HashMap<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

    int total = 0;
    int prevValue = 0;

    // Iterate through each character from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
        char c = s.charAt(i);
        int currentValue = romanValues.get(c);

        if (currentValue < prevValue) {
            // Subtraction case
            total -= currentValue;
        } else {
            // Addition case
            total += currentValue;
        }

        // Update prevValue for the next iteration
        prevValue = currentValue;
    }

        return total;
}

public static void main(String[] args) {
    System.out.println(romanToInt("III"));     // Output: 3
    System.out.println(romanToInt("LVIII"));   // Output: 58
    System.out.println(romanToInt("MCMXCIV")); // Output: 1994
}
}

