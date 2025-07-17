package July;

import java.util.HashMap;

public class LRUCache {
    class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private final int capacity;
    private HashMap<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        // Dummy head and tail to avoid null checks
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        moveToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Update value and move to front
            Node node = map.get(key);
            node.value = value;
            moveToFront(node);
        } else {
            // Create new node
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToFront(newNode);

            if (map.size() > capacity) {
                // Remove LRU from list and map
                Node lru = tail.prev;
                removeNode(lru);
                map.remove(lru.key);
            }
        }
    }

    // Helper to add node right after head (most recently used)
    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    // Helper to remove a node from the list
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper to move node to the front (most recently used)
    private void moveToFront(Node node) {
        removeNode(node);
        addToFront(node);
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);

        lRUCache.put(1, 1);    // cache: {1=1}
        lRUCache.put(2, 2);    // cache: {1=1, 2=2}
        System.out.println(lRUCache.get(1)); // returns 1

        lRUCache.put(3, 3);    // evicts key 2; cache: {1=1, 3=3}
        System.out.println(lRUCache.get(2)); // returns -1

        lRUCache.put(4, 4);    // evicts key 1; cache: {4=4, 3=3}
        System.out.println(lRUCache.get(1)); // returns -1
        System.out.println(lRUCache.get(3)); // returns 3
        System.out.println(lRUCache.get(4)); // returns 4
    }
}
