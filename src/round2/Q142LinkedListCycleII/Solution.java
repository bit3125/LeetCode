package round2.Q142LinkedListCycleII;

import structures.ListNode;

public class Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;

        ListNode cycleEntry = hasCycle(head);
        if (cycleEntry==null)
            return null;
        // else: hasCycle
        int cycleLen = cntCycleLen(cycleEntry);

        return findCycleEntry(head, cycleLen);
    }

    /**
     * @return : one of nodes in the cycle, null if there is no cycle
     * */
    public ListNode hasCycle(ListNode head) {
        if (head==null)
            return null;

        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null)
                break;
            fast = fast.next;

            if (slow == fast)
                return slow;
        }

        return null;
    }

    /**
     * @param head: one of nodes in the cycle,
     * @return : the len of cycle
     * */
    public int cntCycleLen(ListNode head) {
        ListNode p = head.next;
        int cnt = 1;
        while (p != head) {
            p = p.next;
            cnt++;
        }

        return cnt;
    }

    public ListNode findCycleEntry(ListNode head, int cycleLen) {
        if (head==null)
            return null;

        ListNode fast = head, slow = head;
        for (int i = 0; i < cycleLen; i++) {
            fast = fast.next;
        }
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

}