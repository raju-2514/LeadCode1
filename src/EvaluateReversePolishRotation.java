package July;

import java.util.Stack;

public class EvaluateReversePolishRotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            // If token is an operator, pop two operands and apply operation
            if (isOperator(token)) {
                int b = stack.pop(); // Second operand
                int a = stack.pop(); // First operand
                int result = applyOperator(a, b, token);
                stack.push(result);
            } else {
                // It's a number, push to stack
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop(); // Final result
    }

    private boolean isOperator(String token) {
        return "+-*/".contains(token);
    }

    private int applyOperator(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b; // Division truncates toward zero
            default: throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }

    public static void main(String[] args) {
        EvaluateReversePolishRotation sol = new EvaluateReversePolishRotation();

        String[] tokens1 = {"2", "1", "+", "3", "*"};
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

        System.out.println("Result 1: " + sol.evalRPN(tokens1)); // Output: 9
        System.out.println("Result 2: " + sol.evalRPN(tokens2)); // Output: 6
        System.out.println("Result 3: " + sol.evalRPN(tokens3)); // Output: 22
    }
}
