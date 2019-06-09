package round2.Q206ReverseLinkedList;

import structures.ListNode;

class Solution {

    public ListNode reverseList(ListNode head) {
        if (head==null)
            return null;
        // head!=null

        ListNode prev = null, cur = head, next;

        while (cur!=null) {
            next = cur.next; // 这里next只是作为tmp暂存cur.next 故放在这里就好，这种写法可以写的很简洁
            cur.next = prev;

            //swap
            prev = cur;
            cur = next;
        }

        return prev;
    }

}