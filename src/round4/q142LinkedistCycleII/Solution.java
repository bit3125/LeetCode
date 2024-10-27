package round4.q142LinkedistCycleII;

import structures.ListNode;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        // find the cycle
        ListNode nodeInCycle = getOneNodeInCycle(head);
        if (nodeInCycle == null) {
            return null;
        }

        // cnt
        int cnt = getNodesCntInCycle(nodeInCycle);

        // find the first node
        ListNode p1 = head, p2 = head;
        for (int i = 0; i < cnt; i++) {
            p1 = p1.next;
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

    private ListNode getOneNodeInCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head, fast = head.next;
        while (slow != null && fast != null) {
            if (fast == slow) {
                return fast;
            }

            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }

        return null;
    }

    private int getNodesCntInCycle(ListNode node) {
        if (node == null) {
            return 0;
        }

        int cnt = 1;
        ListNode p = node.next;
        while (p != node) {
            p = p.next;
            cnt++;
        }

        return cnt;
    }
}