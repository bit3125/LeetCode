package round2.Q141LinkedListCycle;

import structures.ListNode;

public class Solution {

    public boolean hasCycle(ListNode head) {
        if (head==null)
            return false;

        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null)
                break;
            fast = fast.next;

            if (slow == fast)
                return true;
        }

        return false;
    }

}