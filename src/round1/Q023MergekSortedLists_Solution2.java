
package round1;

import structures.ListNode;
import java.util.Comparator;
import java.util.PriorityQueue;

/**�㷨����������Solution1��˼·
 * Solution1��ÿ�αȽ϶���Ԫ��֮����һ�˶�Ҫ���±Ƚϣ�ÿ�αȽϵ������Զ����˷���
 * ������������п��ǣ����ÿ�ζ��ܰѶ���Ԫ�صıȽϽ���洢���������˱Ƚϵ�ʱ����������������ô�����Ż����Ӷ�
 * �ɴ��뵽ʹ��heap���б���
 * Tn=O(nlogk), Sn=Ok
 *
 * https://www.nowcoder.com/discuss/150620?type=2&order=0&pos=57&page=1
 * */

public class Q023MergekSortedLists_Solution2 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0)
            return null;

        ListNode newHead = new ListNode(-1);
        ListNode pNew = newHead;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(  //***bug:���Ǽ�<>�����ƶ�
        new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);  //***bug:д��������
            }
        });

        for (int i = 0; i < lists.length; i++) {
            if (lists[i]!=null)
                heap.add(lists[i]);
        }

        ListNode tobeInsert = null;
        while (!heap.isEmpty()){
            tobeInsert = heap.poll();
            if (tobeInsert.next != null)
                heap.add(tobeInsert.next);
            pNew.next = tobeInsert;
            pNew = pNew.next;
            tobeInsert.next = null; //�������
        }

        return newHead.next;
    }

}
