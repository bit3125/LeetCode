package leetcode.solutions;

import leetcode.structures.ListNode;

public class Q083RemoveDuplicatesfromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head==null)
            return null;

        ListNode tmp = new ListNode(-1);
        tmp.next = head;
        head = tmp;

        ListNode p = head.next, pp;
        while (p != null) {
            while (p != null && p.next!=null && p.next.val==p.val) {
                removeNext(p);
            }
            p = p.next;
        }

        return head.next;
    }

    private ListNode removeNext(ListNode node) {
        if (node==null || node.next==null)
            return null;

        ListNode ret = node.next;
        node.next = ret.next;
        ret.next = null;
        return ret;
    }

}
