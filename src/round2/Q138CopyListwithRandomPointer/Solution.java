package round2.Q138CopyListwithRandomPointer;

class Solution {

    public Node copyRandomList(Node head) {
        if (head==null)
            return null;

        // copy nodes (without random pointer)
        Node p = head ;
        while (p != null) {
            insertAfter(p, p.val);
            p = p.next.next;
        }
        // copy random pointer
        p = head;
        while (p != null) {
            p.next.random = p.random==null?null:p.random.next;
            p = p.next.next;
        }
        // split list
        return splitList(head)[1];
    }

    public void insertAfter(Node node, int val) {
        if (node==null)
            return ;

        Node newNode = new Node();
        newNode.val = val;
        newNode.next = node.next;
        node.next = newNode;
    }

    public Node[] splitList(Node head) {
        Node newHead = new Node();
        Node p = head, pNew = newHead;

        while (p != null) {
            pNew.next = removeAfter(p);

            p = p.next;
            pNew = pNew.next;
        }
        return new Node[]{head, newHead.next};
    }

    public Node removeAfter(Node node) {
        if (node==null || node.next==null)
            return null;

        Node ret = node.next;
        node.next = node.next.next;
        ret.next = null;
        return ret;
    }

}