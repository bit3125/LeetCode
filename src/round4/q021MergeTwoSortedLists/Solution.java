package round4.q021MergeTwoSortedLists;

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        // len(list1) >= 1 && len(list2) >= 1
        ListNode head = new ListNode(-1), p = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = list1;

                list1 = list1.next; // ÒÆÎ»
                p = p.next; // ÒÆÎ»
                p.next = null; // ¶ÏÁ´
            } else {
                p.next = list2;

                list2 = list2.next; // ÒÆÎ»
                p = p.next; // ÒÆÎ»
                p.next = null; // ¶ÏÁ´
            }
        }
        if (list1 != null) {
            p.next = list1;
        } else {
            p.next = list2;
        }

//        while (list1 != null) {
//            p.next = list1;
//
//            list1 = list1.next; // ÒÆÎ»
//            p = p.next; // ÒÆÎ»
//            p.next = null; // ¶ÏÁ´
//        }
//        while (list2 != null) {
//            p.next = list2;
//
//            list2 = list2.next; // ÒÆÎ»
//            p = p.next; // ÒÆÎ»
//            p.next = null; // ¶ÏÁ´
//        }

        return head.next;
    }
}