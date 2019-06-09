/**
 * Tn = On, Sn = On
 * */
package round2.Q002AddTwoNumbers;

import structures.ListNode;

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null || l2==null)
            return l1==null?l2:l1;

        ListNode resHead = new ListNode(-1), p1 = l1, p2 = l2, pr = resHead;
        int sum, carry = 0;
        while (p1 != null && p2 != null) {
            sum = p1.val + p2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            pr.next = new ListNode(sum);

            pr = pr.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        while (p1 != null) {
            sum = p1.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            pr.next = new ListNode(sum);

            pr = pr.next;
            p1 = p1.next;
        }
        while (p2 != null) {
            sum = p2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            pr.next = new ListNode(sum);

            pr = pr.next;
            p2 = p2.next;
        }
        if (carry!=0)
            pr.next = new ListNode(carry);

        return resHead.next;
    }

}