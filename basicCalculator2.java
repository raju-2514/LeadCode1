package December;

import java.util.Stack;

public class basicCalculator2 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char op = '+';

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Build number
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            // If operator or end of string
            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                if (op == '+') {
                    stack.push(num);
                } else if (op == '-') {
                    stack.push(-num);
                } else if (op == '*') {
                    stack.push(stack.pop() * num);
                } else if (op == '/') {
                    stack.push(stack.pop() / num); // truncates toward zero
                }

                op = ch;
                num = 0;
            }
        }

        // Sum all values in stack
        int result = 0;
        for (int val : stack) {
            result += val;
        }

        return result;
    }

    public static void main(String[] args) {
        String ch="3*4";
        basicCalculator2 ob=new basicCalculator2();
        System.out.println(ob.calculate(ch));

    }
}
