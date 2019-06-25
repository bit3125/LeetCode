package round2.Q206ReverseLinkedList;

import structures.ListNode;

class Solution {

    public ListNode reverseList(ListNode head) {
        if (head==null)
            return null;
        // head!=null

        ListNode prev = null, cur = head, next;

        while (cur!=null) {
            next = cur.next; // ����nextֻ����Ϊtmp�ݴ�cur.next �ʷ�������ͺã�����д������д�ĺܼ��
            cur.next = prev;

            //swap
            prev = cur;
            cur = next;
        }

        return prev;
    }

}