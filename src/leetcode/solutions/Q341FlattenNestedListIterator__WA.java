package leetcode.solutions;

import leetcode.structures.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * ֮ǰ����Ϊ�����ø����ռ���д洢������ʹ��Ƕ�׵�����ģʽ������ʧ����
 *
 * �ȼ���NestedInteger������Ϊ��=>����������Integer��֤��null������List������ǿ�List....
 * �ʴ˷�WA�������A�ˣ�
 * ��������Ϊ���Сbug�ǿ��Խ����
 * �����Ҳ�֪������ôд������
 */
public class Q341FlattenNestedListIterator__WA {
    public class NestedIterator implements Iterator<Integer> {
        private List<NestedInteger> data;
        private int curIdx; //��δʹ�õ�Ԫ�ص�idx
        private Stack<NestedIterator> itersStack;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.data = nestedList;
            this.curIdx = 0;
            this.itersStack = new Stack<>();
        }

        /**�ٶ���׼��ֻ�е�hasNextΪtrue������²Ż����next
         * �ʵ���next��ʱ����Ĭ��hasNext=true
         *
         * */
        @Override
        public Integer next() {
            if (!hasNext())
                return null;

            if (itersStack.isEmpty()) { //ջ����ȡ���������
                NestedInteger curNest = data.get(curIdx);
                curIdx++;
                if (curNest.isInteger()) {
                    return curNest.getInteger();//is Integer��curIdx++ then return
                } else { //curNest is list
                    itersStack.push(new NestedIterator(curNest.getList()));
                }
            }
            // δreturn��ʹ�õ�����������˴���stack�ز�Ϊ�գ���stack�н�ʣ��Ч��������
            //ȥ�����õ������Ĺ�������hasNext����
            //��next�ڿ�ͷ�ص���hasNext���ʿ��Ա�֤�ڵ���next����֮ǰ��itersStack�����еĵ�����������Ч��

            return itersStack.peek().next();
        }

        /**Ҫ�������stack�����е���Ч��������
         * Ȼ��return �Ƿ���next
         * */
        @Override
        public boolean hasNext() {
            while (!itersStack.isEmpty() && !itersStack.peek().hasNext()) //ȥ�����õ�����
                itersStack.pop();
            return curIdx < data.size() || !itersStack.isEmpty();
        }
    }

}