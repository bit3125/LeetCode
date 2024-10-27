package round4.q148SortList;

import structures.ListNode;

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // len(head) >= 2
        ListNode[] ls = split(head);
        return mergeCore(sortList(ls[0]), sortList(ls[1]));
    }

    private ListNode mergeCore(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        // len(l1) >= 1 && len(l2) >= 1
        ListNode retHead = new ListNode(-1), p = retHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1; // join
                l1 = l1.next; // forward

            } else {
                p.next = l2; // join
                l2 = l2.next; // forward
            }

            p.next.next = null; // cut
            p = p.next; // forward
        }


        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return retHead.next;
    }

    private ListNode[] split(ListNode head) {
        if (head == null) {
            return new ListNode[]{null, null};
        }
        if (head.next == null) {
            return new ListNode[]{head, null};
        }

        // len(head) >= 2
        ListNode slow = head, fast = head.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }

        fast = slow.next; // store temporally
        slow.next = null; // cut
        return new ListNode[]{head, fast};
    }
}