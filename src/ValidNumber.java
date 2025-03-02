package February;

public class ValidNumber {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenE = false;
        boolean seenSign = false;

        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigit = true;
            } else if (c == '+' || c == '-') {
                if (seenSign || seenDigit || seenDot) {
                    return false; // Sign must be at the start or after 'e'
                }
                seenSign = true;
            } else if (c == '.') {
                if (seenDot || seenE) {
                    return false; // Dot must appear only once and not after 'e'
                }
                seenDot = true;
            } else if (c == 'e' || c == 'E') {
                if (seenE || !seenDigit) {
                    return false; // 'e' must appear only once and after a digit
                }
                seenE = true;
                seenDigit = false; // Reset digit flag to ensure there's a number after 'e'
                seenSign = false; // Allow sign after 'e'
                seenDot = false; // No dots allowed after 'e'
            } else {
                return false; // Invalid character
            }
        }
        return seenDigit;
    }

    public static void main(String[] args) {
        ValidNumber solution = new ValidNumber();
        System.out.println(solution.isNumber("0")); // true
        System.out.println(solution.isNumber("e")); // false
        System.out.println(solution.isNumber(".")); // false
        System.out.println(solution.isNumber("2e10")); // true
        System.out.println(solution.isNumber("-90E3")); // true
        System.out.println(solution.isNumber("3e+7")); // true
        System.out.println(solution.isNumber("95a54e53")); // false
    }
}
