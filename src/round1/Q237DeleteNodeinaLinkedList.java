package round1;

import structures.ListNode;

public class Q237DeleteNodeinaLinkedList {
    public void deleteNode(ListNode node) {
        if (node==null || node.next==null)
            return;

        node.val = node.next.val; //node will never be the tail node
        node.next = node.next.next;
    }
}
