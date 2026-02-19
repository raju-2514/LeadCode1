package February;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> input;
    private Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    // Push element to back of queue
    public void push(int x) {
        input.push(x);
    }

    // Removes the element from the front of the queue
    public int pop() {
        peek(); // Ensure output stack has elements
        return output.pop();
    }

    // Get the front element
    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    // Returns whether the queue is empty
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}
