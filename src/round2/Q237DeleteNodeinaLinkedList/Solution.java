package round2.Q237DeleteNodeinaLinkedList;

import structures.ListNode;

class Solution {
    public void deleteNode(ListNode node) {
        if (node==null)
            return ;

        node.val = node.next.val; //node.next will never be null
        node.next = node.next.next;
    }
}