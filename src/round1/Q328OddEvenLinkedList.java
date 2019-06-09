/**算法分析：Tn=On, Sn=O1
 * 如果使用类冒泡排序法，交换节点中的值不进行拆链操作的话，Tn=On^2，不可取，故必须要拆链
 *
 * 所以归结为一个拆链问题，一分为二，
 * 进一步拆解为若干个拆节点操作的组合，使用removeNext函数作为基本操作
 *
 * */

package round1;

import structures.ListNode;

public class Q328OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head==null)
            return null;

        ListNode headEven = new ListNode(-1), headOdd = new ListNode(-1);
        headOdd.next = head;

        ListNode pOdd = headOdd.next, tailEven = headEven;
        ListNode pOddPrev = headOdd;
        while (pOdd!=null) {
            tailEven.next = removeNext(pOdd);

            tailEven = tailEven.next;
            pOddPrev = pOdd;
            pOdd = pOdd.next;
        } //两种边界条件：1.pOdd.next==null 2.pOdd.next!=null && pOdd.next.next==null
        pOddPrev.next = headEven.next; //最后pOddPrev指向Odd链表的tail.这里也满足headEven为空的情况
        return headOdd.next;
    }

    private ListNode removeNext(ListNode node) {
        if (node.next==null)
            return null;

        ListNode next = node.next;
        node.next = next.next;
        next.next = null;
        return next;
    }
}
