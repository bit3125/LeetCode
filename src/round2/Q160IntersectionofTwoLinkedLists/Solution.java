package round2.Q160IntersectionofTwoLinkedLists;

import structures.ListNode;

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null || headB==null)
            return null;

        ListNode p1 = headA, p2 = headB;
        int lenA = 0, lenB = 0, diff;

        // cnt lengths
        while (p1 != null) {
            lenA++;
            p1 = p1.next;
        }
        while (p2 != null) {
            lenB++;
            p2 = p2.next;
        }
        diff = lenB - lenA;
        // point headA to the shorter one
        if (diff < 0) {
            p1 = headA;
            headA = headB;
            headB = p1;
            diff = -diff;
        }

        // step together
        p1 = headA;
        p2 = headB;
        for (int i = 0; i < diff; i++) {
            p2 = p2.next;
        }
        while (p1 != null && p2 != null) {
            if (p1==p2)
                return p1;
            p1 = p1.next;
            p2 = p2.next;
        }

        return null;
    }

}