/**�㷨������Tn=On, Sn=O1
 * ���ʹ����ð�����򷨣������ڵ��е�ֵ�����в��������Ļ���Tn=On^2������ȡ���ʱ���Ҫ����
 *
 * ���Թ��Ϊһ���������⣬һ��Ϊ����
 * ��һ�����Ϊ���ɸ���ڵ��������ϣ�ʹ��removeNext������Ϊ��������
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
        } //���ֱ߽�������1.pOdd.next==null 2.pOdd.next!=null && pOdd.next.next==null
        pOddPrev.next = headEven.next; //���pOddPrevָ��Odd�����tail.����Ҳ����headEvenΪ�յ����
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
