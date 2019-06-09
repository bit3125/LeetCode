package round2.Q234PalindromeLinkedList.solution2;

import structures.ListNode;

class Solution {

    public boolean isPalindrome(ListNode head) {
        if (head==null)
            return true;

        ListNode[] ls = split(head);
        ls[1] = revertList(ls[1]);

        //***debugging:
        printList(ls[0]);
        printList(ls[1]);

        ListNode p1 = ls[0], p2 = ls[1];
        while (p1 != null) {
            if (p1.val!=p2.val)
                return false;

            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    public ListNode[] split(ListNode head) {
        if (head==null || head.next==null)
            return new ListNode[]{null, null};

        int len = 0;
        ListNode p = head, newHead = null;
        while (p != null) {
            len++;
            p = p.next;
        }
        p = head;
        for (int i = 0; i < len / 2 - 1; i++)
            p = p.next;

        if ((len & 1) == 1) {
            newHead = p.next.next;
            p.next = null;
        } else {
            newHead = p.next;
            p.next = null;
        }
        return new ListNode[]{head, newHead};
    }

    public ListNode revertList(ListNode head) {
        if (head==null)
            return null;

        ListNode prev = null, cur = head, next = head.next;
        while (true) { // 这里写的不好， 参考Q206ReverseLinkedList
            cur.next = prev;

            prev = cur;
            cur = next;
            if (next==null) //***bug: 应该在此处判断
                break;
            next = next.next;
        }

        return prev;
    }

    public void printList(ListNode head) {
        if (head==null)
            return ;

        ListNode p = head;
        while (p != null) {
            System.out.printf("%d, ", p.val);
            p = p.next;
        }
        System.out.println();
    }

}