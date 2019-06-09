/**算法分析：
 * 对solution1改进，干脆使用：双向链表作为数据主体（将prev next 指针信息都存入node，这样就不用另起一个hashmap记录），
 * 针对链表无法完成O1复杂度的get，再使用一个辅助hashmap<key, node>来进行辅助。
 *
 * 同时对代码进行优化，把对双向链表的操作都拆分为两个基本操作：
 * 1.insertToTail(Node node)
 * 2.remove(Node node)
 * 然后所有对链表的操作都可转化为对这两个基本操作的组合，如：
 * 1>.get操作： remove(target);+insertToTail(target);
 * 2>.put操作：比较复杂，见代码
 *
 * 同时可进行进一步优化：对链表结构不但使用头结点来避免空表时的特殊处理，还要加入一个尾结点，这样空表时对尾指针也不用特殊处理了
 *
 * */

package round1;

import java.util.HashMap;
import java.util.Map;

public class Q146LRUCache_Solution2 {

    private static class LRUCache {
        private Node data = new Node(-1, -1);
        private Node tail = data;
        private Map<Integer, Node> key2Node = new HashMap<>();
        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            Node target = key2Node.get(key);
            if (target != null) {
                remove(target);
                insertToTail(target);
                return target.value;
            }else
                return -1;
        }

        public void put(int key, int value) {
            Node target = key2Node.get(key);
            if (target != null) { //key exists
                //update node's value & position
                remove(target);
                if (value == target.value)
                    target.value = value;
                insertToTail(target);
            }else{//key dosent exists
                //delete LRU node
                if (key2Node.size() == capacity)
                    remove(data.next);

                //insert new node
                Node newNode = new Node(key, value);
                insertToTail(newNode);
            }

        }

        private Node insertToTail(Node target){
            tail.next = target ;
            tail.next.prev = tail;
            tail = tail.next;

            if (!key2Node.containsKey(target.key))
                key2Node.put(target.key, target);
            return tail;
        }

        /**
         * Returns: target node if key exist, else null;
         * */
        private Node remove(Node target){
            if (target != null) {
                if (target == tail) //***bug:forget to move tail when target is tail
                    tail = tail.prev;

                target.prev.next = target.next;
                if (target.next!=null) //possible null
                    target.next.prev = target.prev;

                target.next = null;
                target.prev = null;
                if (key2Node.containsKey(target.key))
                    key2Node.remove(target.key); //***bug:forget
            }
            return target;
        }

        private static class Node {
            int key;
            int value;
            Node prev;
            Node next;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
                this.prev = null;
                this.next = null;
            }
        }

        private void printList(){
            Node p = data;
            while (p != null) {
                System.out.println(p.key);
                p = p.next;
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2,1);
        cache.get(2);
        cache.put(3,2);
        cache.get(2);
        cache.get(3);

    }

}
