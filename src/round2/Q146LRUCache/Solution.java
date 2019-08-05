package round2.Q146LRUCache;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private static int capacity;
    private Map<Integer, Node> map; // key, node
    private Node head, tail;

    public LRUCache(int capacity) {
        LRUCache.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        Node target = map.get(key);
        // update position
        removeFromList(target);
        appendToTail(target);

        return target.value;
    }

    public void put(int key, int value) {
        Node target;
        // get target node
        if (map.containsKey(key)) { // exist
            target = map.get(key);
            removeFromList(target);
            if (target.value!=value) // update value
                target.value = value;
        } else { // not exist
            target = new Node(key, value);
            map.put(key, target);

            // invalidate lru item
            if (map.size() > capacity) {
                Node toRemove = head.next;
                removeFromList(toRemove);
                map.remove(toRemove.key); //***bug: map.remove(head.next);
                            // ***bug:removeFromList之后head.next已经改变了
            }
        }
        // append
        appendToTail(target);
    }

    private void removeFromList(Node target) { // not null
        target.prev.next = target.next;
        target.next.prev = target.prev;
        // clean
        target.prev = null;
        target.next = null;
    }

    private void appendToTail(Node target) { // not null, and clean
        Node prev = tail.prev;
        target.prev = prev;
        target.next = tail;
        prev.next = target;
        tail.prev = target;
    }

    private void printList() {
        Node p = head.next;
        while (p != tail) {
            p = p.next;
        }
        System.out.println();
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */