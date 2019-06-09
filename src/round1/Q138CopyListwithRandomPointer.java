package round1;

/**
 * 本Epoch进步在将两个基本操作解耦出来模块化了: copyCurToAppend & removeNext
 * */
public class Q138CopyListwithRandomPointer {

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Node p1 = new Node(), p2;
        p1.next = head;
        head = p1; //insert head node of old list
        Node newHead = new Node();//insert head node of new list
        p1 = head.next;
        //simple copy
        while (p1 != null) {
            copyCurToAppend(p1);
            p1 = p1.next.next;
        }
        //write random pointer
        p1 = head.next;
        while (p1!=null) {
            p1.next.random = p1.random==null?null:p1.random.next; //***bug:.random possible to be null
            p1 = p1.next.next;
        }
        //break the list up
        p1 = head.next; //point to old list
        p2 = newHead; //point to new list
        while (p1 != null) {
            p2.next = removeNext(p1);
            p1 = p1.next;
            p2 = p2.next;
        }

        return newHead.next;
    }

    private void copyCurToAppend(Node cur) {
        if (cur==null)
            return;
        Node newNode = new Node();
        newNode.val = cur.val;
        newNode.next = cur.next;
        cur.next = newNode;
    }

    public Node removeNext(Node node) {
        if (node==null || node.next==null)
            return null;

        Node ret = node.next;
        node.next = ret.next;
        ret.next = null;
        return ret;
    }

}

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}