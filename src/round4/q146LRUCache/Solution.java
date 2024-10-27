package round4.q146LRUCache;

import java.util.HashMap;
import java.util.Map;

/** 看round3的分析, 贼彻底
 * 关键点：
 * 1. o1复杂度查找, 故map
 * 2. o1复杂度删除, 故双向链表(从map o1时间找到目标节点, 同时删链表节点需要其prev节点, 故要双向链表)
 * 3. 需要o1 插头/去尾(清理元素), 故head/tail都是必须的
 * 4. o1去尾的时候, 需要快速反映射回map中的key做清理, 故Node除了value还必须存储key
 *
 * */

class LRUCache {
    class ListNode {
        int key;
        int value;
        ListNode prev;
        ListNode next;
        ListNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    ListNode head;
    ListNode tail;
    Map<Integer, ListNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-2, -2);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    public int get(int key) {
        if (!this.map.containsKey(key)){
            return -1;
        }

        ListNode target = this.map.get(key);
        removeNode(target);
        insertAtFirst(target);
        return target.value;
    }

    public void put(int key, int value) {
        ListNode target;
        // search
        if (this.map.containsKey(key)) {
            target = this.map.get(key);
            target.value = value;
            removeNode(target);
            insertAtFirst(target);
            return;
        }

        // set
        target = new ListNode(key, value);
        this.map.put(key, target);
        insertAtFirst(target);
        // trim
        if (this.map.size() > this.capacity) {
            ListNode removed = removeLast();
            if (removed != null) {
                this.map.remove(removed.key);
            }
        }
    }
    private void removeNode(ListNode target) {
        if (target == null) {
            return;
        }

        if (target.prev != null) {
            target.prev.next = target.next;
        }
        if (target.next != null) {
            target.next.prev = target.prev;
        }
        target.prev = null;
        target.next = null;
    }

    private ListNode removeLast() {
        if (tail.prev == head) {
            return null;
        }

        ListNode target = tail.prev;
        removeNode(target);
        return target;
    }
    private void insertAtFirst(ListNode target) {
        if (target == null) {
            return;
        }

        if (head.next != null) {
            head.next.prev = target;
            target.next = head.next;
        }
        head.next = target;
        target.prev = head;
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */