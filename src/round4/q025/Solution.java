package round4.q025;

import structures.ListNode;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;

        ListNode front = fakeHead, rear = front, tmp;
        // 1st pointer(front): points to the prev node of the head node of the linkedList slice to be reversed
        // 2nd pointer(rear): points to the tail node of the linkedList slice to be reversed
        // 3rd pointer(tmp): stores the tmp pointer which the tail node points to
        while (front.next != null) {
            for (int i = 0; i < k; i++) {
                rear = rear.next;
                if (rear == null) {
                    return fakeHead.next; // fast return to avoid the reverse logic below
                }
            }

            tmp = rear.next; // store
            // reverse
            ListNode[] res = reverseLinkedList(front.next, rear);
            // join
            front.next = res[0];
            res[1].next = tmp;

            // forward
            front = res[1];
            rear = front;
        }

        return fakeHead.next;
    }

    // reverseLinkedList cuts and reverses the linkedList slice from head to
    // tail(included)
    private ListNode[] reverseLinkedList(ListNode head, ListNode tail) {
        if (head == null || head == tail) {
            return new ListNode[]{head, tail};
        }

        // len >= 2
        ListNode prev = null, cur = head, next;
        while (prev != tail) {
            next = cur.next; // store

            cur.next = prev;

            // forward
            prev = cur;
            cur = next;
        }

        return new ListNode[]{tail, head};
    }
}