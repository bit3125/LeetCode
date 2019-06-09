
package round1;

import structures.ListNode;
import java.util.Comparator;
import java.util.PriorityQueue;

/**算法分析：基于Solution1的思路
 * Solution1中每次比较顶端元素之后，下一趟都要重新比较，每次比较的有序性都被浪费了
 * 从这里出发进行考虑，如果每次都能把顶端元素的比较结果存储下来，下趟比较的时候再利用起来，那么就能优化复杂度
 * 由此想到使用heap进行保存
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
        PriorityQueue<ListNode> heap = new PriorityQueue<>(  //***bug:忘记加<>泛型推断
        new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);  //***bug:写成了逆序
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
            tobeInsert.next = null; //断链清空
        }

        return newHead.next;
    }

}
