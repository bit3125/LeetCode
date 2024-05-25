package round3.q019RemoveNthNodeFromEndofList;

import structures.ListNode;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode tmpHead = new ListNode(-1);
        tmpHead.next = head;
        ListNode fast = head, slow = head, prevSlow = tmpHead;

        for (int i = 0; i < n; i++) {
            if (fast == null) {
                return null;
            }

            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;

            prevSlow = slow;
            slow = slow.next;
        }
        removeAndReturnNext(prevSlow);

        return tmpHead.next;
    }

    public ListNode removeAndReturnNext(ListNode node) {
        if (node == null || node.next == null) {
            return null;
        }

        ListNode ret = node.next;
        node.next = node.next.next;
        ret.next = null;

        return ret;
    }
}