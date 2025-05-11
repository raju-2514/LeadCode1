package Basic;

import java.util.LinkedList;
import java.util.Queue;

public class QueueCode {

    public static void main(String[] args) {
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        System.out.println("First element using peek(): " + queue.peek()); // Output: 10
    }
}
