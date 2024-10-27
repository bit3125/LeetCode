package round4.q143;

import structures.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode[] results = split(head);
        join(results[0], reverse(results[1]));
    }

    //    private ListNode[] split(ListNode head) {
//        ListNode[] results = new ListNode[2];
//        if (head == null || head.next == null) {
//            results[0] = head;
//            return results;
//        }
//
//        ListNode h1 = new ListNode(-1), h2 = new ListNode(-1);
//        h1.next = head;
//        ListNode p1 = head, p2 = h2;
//        while (p1.next != null) {
//            p2.next = p1.next;
//            p1.next = p1.next.next; // join
//            p2.next.next = null; // cut
//
//            // shift
//            p1 = p1.next; // may be null
//            p2 = p2.next;
//        }
//
//        results[0] = h1.next;
//        results[1] = h2.next;
//        return results;
//    }
    private ListNode[] split(ListNode head) {
        ListNode[] results = new ListNode[2];
        if (head == null || head.next == null) {
            results[0] = head;
            return results;
        }

        ListNode p1 = head, p2 = head.next;
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
            if (p2.next != null) {
                p2 = p2.next;
            }
        }
        // 0 -> 1
        // 0 -> 1 -> 2 -> 3
        // 0 -> 1 -> 2 -> 3 -> 4

        results[0] = head;
        results[1] = p1.next;
        p1.next = null; // cut
        return results;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null, cur = head, next;
        while (cur != null) {
            next = cur.next; // store

            cur.next = prev; // reverse

            // shift
            prev = cur;
            cur = next;
        }

        return prev;
    }

    private ListNode join(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode p1 = l1, p2 = l2, tmp;
        while(p2 != null){
            tmp = p2.next; // store
            p2.next = p1.next;
            p1.next = p2;


            // shift
            p1 = p1.next.next;
            p2 = tmp;
        }
        return l1;
    }
}