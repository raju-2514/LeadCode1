package December;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push element x onto stack
    public void push(int x) {
        // Step 1: push x to q2
        q2.offer(x);

        // Step 2: push all elements of q1 into q2 (so x stays on top)
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }

        // Step 3: swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Removes the element on top of the stack
    public int pop() {
        return q1.poll();
    }

    // Get the top element
    public int top() {
        return q1.peek();
    }

    // Return whether the stack is empty
    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.top();   // returns 2
        myStack.pop();   // returns 2
        myStack.empty(); // false
    }
}
