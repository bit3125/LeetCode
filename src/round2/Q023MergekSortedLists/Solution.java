package round2.Q023MergekSortedLists;

import structures.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0)
            return null;
        if (lists.length==1) //2brm
            return lists[0];

        ListNode retHead = new ListNode(-1);
        ListNode pRet = retHead;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });  // never contains null elems
        for (int i = 0; i < lists.length; i++)
            if (lists[i]!=null)
                minHeap.offer(lists[i]);

        while (!minHeap.isEmpty()) {
            ListNode heapTop = minHeap.poll();
            pRet.next = heapTop;
            if (heapTop.next!=null)
                minHeap.offer(heapTop.next);

            heapTop.next = null;
            pRet = pRet.next;
        }

        return retHead.next;
    }

}