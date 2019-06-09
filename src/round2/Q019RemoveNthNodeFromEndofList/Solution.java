package round2.Q019RemoveNthNodeFromEndofList;

import structures.ListNode;

class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null || n<1)
            return null;

        ListNode tmp = new ListNode(-1);
        tmp.next = head;
        head = tmp;

        ListNode slow = head, fast = head;
        for (int i = 0; i < n+1; i++)
            fast = fast.next;

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        removeNext(slow);
        return head.next;
    }

    public void removeNext(ListNode head) {
        if (head==null || head.next==null)
            return;

        ListNode tmp = head.next;
        head.next = head.next.next;
        tmp.next = null;
    }

}