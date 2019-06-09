/**算法分析：类似于双链表合并
 * Tn=O(kn), Sn=O1
 * */

package round1;

import structures.ListNode;

import java.util.Arrays;

public class Q023MergekSortedLists_Solution1 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0)
            return null;

        ListNode[] ps = Arrays.copyOf(lists, lists.length);
        ListNode newHead = new ListNode(-1);
        ListNode pNew = newHead;
        while (true){
            //出口判断
            int nullCnt = 0;
            for (int i = 0; i < ps.length; i++) {
                if (ps[i]==null)
                    nullCnt++;
            }
            if (nullCnt==ps.length)
                break;
            //compare
                //init minIdx
            int minIdx = 0;
            for (int i = 0; i < ps.length; i++) {
                if (ps[i] != null){
                    minIdx = i;
                    break;
                }
            }
                //search for minIdx
            for (int i = 0; i < ps.length; i++) {
                if (ps[i]!=null && ps[i].val<ps[minIdx].val) { //短路与
                    minIdx = i;
                }
            }
            pNew.next = ps[minIdx];
            pNew = pNew.next;
            ps[minIdx] = ps[minIdx].next;
            pNew.next = null;//一定要断链清空
        }

        return newHead.next;
    }

}
