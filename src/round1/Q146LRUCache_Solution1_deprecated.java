/**�㷨������
 *
 * put��get������Ҫ��O1�ĸ��Ӷ�
 * get O1=>ֻ��ʹ��HashMap���洢����
 *
 * ����Ҫʵ��LRU�㷨������Ҫά��һ������
 *  * ����ʹ�õ������ݽṹΪ��һ��HashMap���洢��ֵ�ԣ�һ��Queue�����ǵ�ɾ��O1��ʹ��LinkedList����ά��LRU˳��
 *
 * get����ѯkey��Ӧ��value���أ����޸�LRU���У�����޸ĵĲ���Ҳ����O1���޸ķ�Ϊ������1.�Ӷ������ҵ���
 * ��key��Ӧ�Ľڵ㣨�����㷨On����2.���˽ڵ��Ƶ�ͷ����O1��
 * put������key��Ӧ��value����cache�ռ䲻���ʱ����Ҫ�ҵ�LRU�㷨��Ҫremove�ļ�ֵ�Խ���ɾ��
 * ���������+ɾ���Ĳ���Ҳ����O1����LRU���еĲ�����Ϊ������1.���ҵ�����β��O1����2.ɾ�������ж�Ӧ�ڵ㣨O1��
 *
 * ��������Ĺؼ���ת��Ϊ����ô��get�����ж�LRUQ���޸Ĳ����Ĳ��Ҳ����Ż���O1
 * �뵽��ʹ��һ��HashMap�����<key, pPrevNode>��PPrevNodeΪ��key��Q�ж�Ӧ�Ľڵ��ͷָ�룬����������O1���Ӷ�
 * ����һ��LinkedList��ʵ�ֲ��Ҳ���
 *
 * ���㷨Ϊ��ʼ�沢δд��AC����ɰ��Solution2
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
         * ����ʵ�����¹��ܣ�
         * ��key���ڣ�return value and update qnode
         * ��key�����ڣ�do nothing and return -1
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
         * ����ʵ�����¹��ܣ�
         * ��key���ڣ�update value and update q
         * || delete another value + delete another qnode + insert another value + insert another qnode
         * ��key�����ڣ�insert key and insert qnode
         * */
        public void put(int key, int value) {
            if (data.containsKey(key)) {
                removeKeyQNode(key);
                insertToTailQNode(key);
            }else{
                if (data.size()==capacity){
                    data.remove(q.next.key);//***bug:©��
                    removeFromHeadQNode();
                }
                insertToTailQNode(key);//***bug:д�������if����
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
            if (q.next != null) { //����
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
