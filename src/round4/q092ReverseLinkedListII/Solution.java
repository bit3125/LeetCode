package round4.q092ReverseLinkedListII;

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left > right) {
            return head;
        }

        // len(head) >= 2

        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode[] results = extractList(head, left, right);
        fakeHead.next = results[0];
        insertAfter(fakeHead, reverse(results[1]), left + 1 - 1);

        return fakeHead.next;
    }

    // returns: results[0] maybe null, results[1] must be not null
    public ListNode[] extractList(ListNode head, int left, int right) {
        // len(head) >= 2 && left < right && right <= len(ListNode head)
        ListNode[] results = new ListNode[2];
        if (head == null) {
            return results;
        }

        // consider:
        // 1. len(head) == 2
        // 2. left == right
        // 3. left == position(head)
        // 4. pRight == null

        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;

        int idx = 1;
        ListNode pLeft, pRight, originListTail;
        // find left node
        ListNode prev = fakeHead, cur = fakeHead.next;
        while (cur != null /* will not happened*/ && idx < left) {
            prev = cur;
            cur = cur.next;
            idx++;
        }
        // idx == left
        pLeft = cur;
        // prev == fakeHead's tail
        originListTail = prev; // maybe fakeHead
        originListTail.next = null; // cut

        // find right node
        while (cur != null /* will not happened*/ && idx < right) {
            cur = cur.next;
            idx++;
        }
        // idx == right
        pRight = cur;

        // postprocessing
        originListTail.next = pRight.next; // join. maybe null
        pRight.next = null; // cut

        results[0] = fakeHead.next;
        results[1] = pLeft;
        return results;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // len(list) must >= 2

        ListNode prev = null, cur = head, next;
        while (cur != null) {
            next = cur.next; // store
            cur.next = prev;

            // shift
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public ListNode insertAfter(ListNode l1, ListNode l2, int position) {
        if (l1 == null || l2 == null) {
            return l1;
        }

        ListNode tail1, tail2;
        // find tail
        ListNode p = l2;
        while (p.next != null) {
            p = p.next;
        }
        tail2 = p;

        int idx = 1;
        p = l1;
        while (p != null && idx < position) {
            p = p.next;
            idx++;
        }
        tail1 = p;

        // idx == position
        tail2.next = tail1.next;
        tail1.next = l2;
        return l1;
    }
}
