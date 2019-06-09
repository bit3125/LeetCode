/**算法分析：
 *
 * put与get操作都要求O1的复杂度
 * get O1=>只能使用HashMap来存储数据
 *
 * 由于要实现LRU算法，故需要维护一个队列
 *  * 综上使用到的数据结构为：一个HashMap来存储键值对，一个Queue（考虑到删除O1，使用LinkedList）来维护LRU顺序
 *
 * get：查询key对应的value返回，并修改LRU队列，这个修改的操作也必须O1。修改分为两步：1.从队列中找到这
 * 个key对应的节点（常规算法On）；2.将此节点移到头部（O1）
 * put：放入key对应的value，当cache空间不足的时候需要找到LRU算法需要remove的键值对进行删除
 * ，这个查找+删除的操作也必须O1。对LRU队列的操作分为两步：1.查找到队列尾（O1）；2.删除队列中对应节点（O1）
 *
 * 所以问题的关键就转化为，怎么把get操作中对LRUQ的修改操作的查找操作优化到O1
 * 想到再使用一个HashMap，存放<key, pPrevNode>，PPrevNode为该key在Q中对应的节点的头指针，这样就能在O1复杂度
 * 内在一个LinkedList中实现查找操作
 *
 * 本算法为初始版并未写到AC，完成版见Solution2
 *
 *
 * */

package round1;

import java.util.HashMap;
import java.util.Map;

public class Q146LRUCache_Solution1_deprecated {

    private static class LRUCache {
        private Map<Integer, Integer> data = new HashMap<>();
        private qNode q = new qNode(-1); //delete head first
        private qNode qTail = q;
        private Map<Integer, qNode> qNodeMap = new HashMap<>(); //<key, prev>
        private int capacity ;

        private static class qNode {
            int key;
            qNode next;
            qNode(int key) {
                this.key = key;
                this.next = null;
            }
        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        /**Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
         *
         * 假设实现以下功能：
         * 若key存在：return value and update qnode
         * 若key不存在：do nothing and return -1
         * */
        public int get(int key) {
            Integer value = data.get(key);
            if (value != null) {
                removeKeyQNode(key);
                insertToTailQNode(key);
                return value;
            } else {
                return -1;
            }
        }

        /** Set or insert the value if the key is not already present. When the cache reached its capacity,
         * it should invalidate the least recently used item before inserting a new item.
         *
         * 假设实现以下功能：
         * 若key存在：update value and update q
         * || delete another value + delete another qnode + insert another value + insert another qnode
         * 若key不存在：insert key and insert qnode
         * */
        public void put(int key, int value) {
            if (data.containsKey(key)) {
                removeKeyQNode(key);
                insertToTailQNode(key);
            }else{
                if (data.size()==capacity){
                    data.remove(q.next.key);//***bug:漏了
                    removeFromHeadQNode();
                }
                insertToTailQNode(key);//***bug:写在上面的if里了
            }
            data.put(key, value) ;
        }

        /**create key node at tail
         * */
        private void insertToTailQNode(int key){

            qTail.next = new qNode(key);
            qNodeMap.put(key, qTail);
            qTail = qTail.next;
        }

        /**move key node to tail
         * */
        private void updateQNode(int key){
            qNode prev = qNodeMap.get(key);
//            System.out.println("qNode prev = qNodeMap.get(key);");
            qNode cur = prev.next;
//            System.out.println("qNode cur = prev.next; ");

            prev.next = cur.next;
//            System.out.println("prev.next = cur.next;");
            cur.next = null;
//            System.out.println("cur.next = null;");
            qNodeMap.put(prev.next.key, prev);
//            System.out.println("qNodeMap.put(prev.next.key, prev);");

            //
            qTail.next = cur;
//            System.out.println("qTail.next = cur;");
            qNodeMap.put(cur.key, qTail);
//            System.out.println("qNodeMap.put(cur.key, qTail);");
            qTail = cur;
//            System.out.println("qTail = cur;");
        }

        /**delete node from head
         * */
        private qNode removeFromHeadQNode(){
            qNode ret = q.next;
            if (q.next != null) { //多余
                qNodeMap.remove(q.next);
                if (q.next.next != null) {
                    qNodeMap.put(q.next.next.key, q);
                }
                    q.next = q.next.next;
            }
            return ret;
        }

        private qNode removeKeyQNode(int key){

            qNode prev = qNodeMap.get(key);
            qNode cur = prev.next;

            prev.next = cur.next;
            cur.next = null;
            qNodeMap.put(prev.next.key, prev);

            return cur;
        }
    }


}
