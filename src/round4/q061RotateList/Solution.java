package round4.q061RotateList;

import structures.ListNode;

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k < 0) {
            return head;
        }

        // len >= 2
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }

        // rotate
        k = k % len;
        k = len - k;
        if (k == 0) {
            return head;
        }

        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        p = fakeHead;
        for (int i = 0; i < k; i++) {
            p = p.next;
        }

        fakeHead.next = p.next; // insert
        p.next = null; // cut
        // find the tail
        p = fakeHead; // init
        while (p.next != null) {
            p = p.next;
        }
        p.next = head; // append

        return fakeHead.next;
    }
}