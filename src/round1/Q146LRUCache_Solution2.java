/**�㷨������
 * ��solution1�Ľ����ɴ�ʹ�ã�˫��������Ϊ�������壨��prev next ָ����Ϣ������node�������Ͳ�������һ��hashmap��¼����
 * ��������޷����O1���Ӷȵ�get����ʹ��һ������hashmap<key, node>�����и�����
 *
 * ͬʱ�Դ�������Ż����Ѷ�˫������Ĳ��������Ϊ��������������
 * 1.insertToTail(Node node)
 * 2.remove(Node node)
 * Ȼ�����ж�����Ĳ�������ת��Ϊ��������������������ϣ��磺
 * 1>.get������ remove(target);+insertToTail(target);
 * 2>.put�������Ƚϸ��ӣ�������
 *
 * ͬʱ�ɽ��н�һ���Ż���������ṹ����ʹ��ͷ���������ձ�ʱ�����⴦����Ҫ����һ��β��㣬�����ձ�ʱ��βָ��Ҳ�������⴦����
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
