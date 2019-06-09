package round2.Q148SortList;

import structures.ListNode;

class Solution {
    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null)
            return head;

        //else: len>=2
        ListNode[] ls = split(head);
        ls[0] = sortList(ls[0]);  //***bug: forget to deassign the pointer
        ls[1] = sortList(ls[1]);
        return mergeCore(ls[0], ls[1]);
    }

    public ListNode[] split(ListNode head) {
        if (head==null || head.next==null)
            return null;

        //else: len>=2
        ListNode slow = head, fast = head.next;
        while (fast!=null) {
            fast = fast.next;
            if (fast == null)
                break;

            slow = slow.next;
            fast = fast.next;
        }

        ListNode[] ret = new ListNode[2];
        ret[0] = head;
        ret[1] = slow.next;
        slow.next = null;
        return ret;
    }

    public ListNode mergeCore(ListNode l1, ListNode l2 ) {
        if (l1==null||l2==null)
            return l1==null?l2:l1;

        ListNode newHead = new ListNode(-1);
        ListNode p1 = l1, p2 = l2, p3 = newHead;
        while (p1!=null && p2!=null) {
            if (p1.val < p2.val) {
                p3.next = p1;
                p1 = p1.next;
            } else {
                p3.next = p2;
                p2 = p2.next;
            }

            p3 = p3.next;
            p3.next = null;
        }
        if (p1!=null)
            p3.next = p1;
        if (p2!=null)
            p3.next = p2;

        return newHead.next;
    }

    public void printList(ListNode head) {
        if (head == null)
            return;

        ListNode p = head;
        while (p!=null) {
            System.out.printf("%d,", p.val);
            p = p.next;
        }
        System.out.println();
    }
}