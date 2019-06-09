package round2.Q328OddEvenLinkedList;

import structures.ListNode;

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head==null)
            return null;

        ListNode newHead = new ListNode(-1);
        ListNode p = head, prev = null, pNew = newHead;
        while (p != null) {
            pNew.next = removeNext(p);

            pNew = pNew.next;
            prev = p ;
            p = p.next;
        }

        // join two list
        prev.next = newHead.next;
        return head;
    }

    /**
     * @return : removed node, null if node.next==null
     * */
    public ListNode removeNext(ListNode node) {
        if (node==null || node.next==null)
            return null;

        // node.next!=null
        ListNode ret = node.next;
        node.next = ret.next;
        ret.next = null;
        return ret;
    }
}