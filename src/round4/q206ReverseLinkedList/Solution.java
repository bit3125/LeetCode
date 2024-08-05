package round4.q206ReverseLinkedList;


import structures.ListNode;

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // len(list) must >= 2

        ListNode p1 = head, p2 = head.next, p3 = head.next.next;
        p1.next = null; // init p1
        while (p2 != null) {
            p2.next = p1;

            p1 = p2;
            p2 = p3;
            if (p3 != null) {
                p3 = p3.next;
            }
        }

        return p1;
    }
}

/*
¸üÓÅÑÅ:
class Solution {

    public ListNode reverseList(ListNode head) {
        if (head==null)
            return null;
        // head!=null

        ListNode prev = null, cur = head, next;

        while (cur!=null) {
            next = cur.next;
            cur.next = prev;

            //swap
            prev = cur;
            cur = next;
        }

        return prev;
    }

}


 */
