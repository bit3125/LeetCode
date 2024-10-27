package round4.q023MergekSortedLists;

import structures.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // init
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode l1, ListNode l2){
                return Integer.compare(l1.val, l2.val);
            }
        });
        ListNode retList = new ListNode(-1);
        ListNode prev = retList, cur = null;
        for(int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minHeap.offer(lists[i]);
            }
        }

        // merge
        while (!minHeap.isEmpty()) {
            cur = minHeap.poll(); // must not null
            if (cur.next != null) {
                minHeap.offer(cur.next);
            }
            cur.next = null; // ¶ÏÁ´

            // join
            prev.next = cur;
            // shift
            prev = prev.next;
        }

        return retList.next;
    }
}