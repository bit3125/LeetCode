package round4.q082RemoveDuplicatesfromSortedListII;

import structures.ListNode;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode prev = fakeHead/*���ڼ�¼ɾ��cur��ʱ����Ҫ��ǰ�ýڵ�*/, cur = head, next = head.next;
        while (next != null) {
            if (cur.val == next.val) {
                while (next != null && cur.val == next.val) {
                    cur.next = next.next;
                    next.next = null; // ����

                    next = cur.next;
                }

                prev.next = cur.next; // delete cur�� prev.next maybe null
                cur.next = null; // ����

                // shift
                if (prev.next == null) {
                    break;
                }
                cur = prev.next;
                next = cur.next;
            } else {
                prev = cur;
                cur = next;
                next = next.next;
            }
        }
        return fakeHead.next;
    }
}