package TopInterviewQuestions;

import java.util.HashMap;

class LRUCache {

    private final int capacity;
    private int size;
    private HashMap<Integer, Node> map;
    private DLL queue;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        this.map = new HashMap<>();
        this.queue = new DLL();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        queue.moveToFront(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            Node newNode = new Node(key, value);
            if (size >= capacity) {
                map.remove(queue.rear.key);
                queue.removeRear();
                size--;
            }
            map.put(key, newNode);
            queue.addToFront(newNode);
            size++;
        } else {
            node.val = value;
            map.put(key, node);
            queue.moveToFront(node);
        }
    }

    private class Node {
        int key, val;
        Node next, prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            next = prev = null;
        }
    }

    private class DLL {
        Node front, rear;

        DLL() {
            front = rear = null;
        }

        public void moveToFront(Node node) {
            if (front == node) {
                return;
            }
            if (node == rear) {
                rear = rear.prev;
                rear.next = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            node.prev = null;
            node.next = front;
            front.prev = node;
            front = node;
        }

        public void addToFront(Node node) {
            if (rear == null) {
                front = rear = node;
            }
            node.next = front;
            front.prev = node;
            front = node;
        }

        public void removeRear() {
            if (rear != null) {
                if (rear == front) {
                    front = rear = null;
                } else {
                    rear = rear.prev;
                    rear.next = null;
                }
            }
        }
    }
}

public class LRU {

    public static void main(String[] args) {
        /*
        ["LRUCache","get","put","get","put","put","get","get"]
[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
         */

        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(2));
        cache.put(2,6);
        System.out.println(cache.get(1));
        cache.put(1,5);
        cache.put(1,2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }


}
