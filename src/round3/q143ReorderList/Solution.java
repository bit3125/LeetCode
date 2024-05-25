package round3.q143ReorderList;

import structures.ListNode;

import java.util.Stack;

class Solution {
    public void reorderList(ListNode head) {
        if (head == null){
            return;
        }
        Stack<ListNode> s = new Stack<>();

        // find the cnt/2 node
        int cnt = 0;
        ListNode prev, cur = head;
        while (cur != null){
            cnt++;
            cur = cur.next;
        }

        // push nodes into stack
        prev = head;
        cur = head;
        for (int i = 0; i < (cnt+1)/2; i++) {
            prev = cur;
            cur = cur.next;
        }
        prev.next = null;

        while(cur != null) {
            prev = cur;
            cur = cur.next;
            prev.next = null;
            s.push(prev);
        }

        // insert
        cur = head;
        while (cur != null && !s.isEmpty()) {
            insertBehind(cur, s.pop());
            cur = cur.next.next;
        }
    }

    public void insertBehind(ListNode head, ListNode node) {
        if (head == null || node == null) {
            return;
        }

        node.next = head.next;
        head.next = node;
    }
}