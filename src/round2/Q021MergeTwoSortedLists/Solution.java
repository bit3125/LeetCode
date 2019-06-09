package round2.Q021MergeTwoSortedLists;

import structures.ListNode;

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null || l2==null)
            return l1==null?l2:l1;

        ListNode newHead = new ListNode(-1);
        ListNode p1 = l1, p2 = l2, pNew = newHead;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                pNew.next = p1;
                p1 = p1.next;

            } else {
                pNew.next = p2;
                p2 = p2.next;
            }
            pNew = pNew.next;
            pNew.next = null;
        }
        if (p1 != null)
            pNew.next = p1;
        if (p2 != null)
            pNew.next = p2;

        return newHead.next;
    }

}
