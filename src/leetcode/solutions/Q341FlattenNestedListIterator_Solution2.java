package leetcode.solutions;

import leetcode.structures.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**�㷨��������ȻWA���㷨�ǿ��еģ���΢�ĸľͿ����ˣ�
 *
 * �����Solution1�������е�stackֻ�����˲���iters���ǰ����������ֿ�����һ�ݣ���Ȼ����Ӷ�Ҳ��On����ʵ�����Ǹ�ʡ�ռ��
 *
 * �˷���Ҫͨ���������ɽ��WA�е����⣺
 * 1.ʹ����һ��nextRet O1�Ŀռ����洢��һ��nextҪreturn���������Ǹ�����Ҫ�ļ��ɣ���Ϊ�����ŵ�NestedInteger���
 * �Ǹ�List�����п���Ϊ�յģ�����Ҫ��ǰȡ�������жϲ�����hasNext��������ȷ���жϳ���Ϊ��Ȼ��return false����Ҫ
 * ��ǰȡ��������ǰȡ������ֻҪ��һ�������ܴ�ס��ô����ʵ���������
 * 2.iters��stack���� NestedIterator��ֻ��List<NestedInteger>��iter��Ҳ��List������iter���������Ϳ��Լ򻯲�����
 * ��Ϊjdk��iter�ǰ�װ���˵�
 *
 * ��hasNext�н���ջ����Чiter����������nextRet�ĸ�ֵ������ͨ��ȡ�����nextRet�ÿգ�����֤��hasNext���ݵ���
 * ��discuss�еĴ𰸲�û�б�֤���ݵ��ԣ�
 *
 * hasNext�е�while�ú���ĥ��ĥ��ʵ�������㹦�ܣ��߼���΢���ӵ�
 * */
public class Q341FlattenNestedListIterator_Solution2 {

    public class NestedIterator implements Iterator<Integer> {

        private Integer nextRet;
        private Stack<Iterator<NestedInteger>> iterStack ;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.iterStack = new Stack<>();
            this.iterStack.push(nestedList.iterator());
        }

        /**�涨��ÿ�ε���next֮ǰ�������һ��hasNext
         * ��stack����Чiters����ա�nextRet�ĸ�ֵ�����Խ���hasNext����
         *
         * ��ȡ��nextRet֮��Ҫ���
         * */
        @Override
        public Integer next() {
            if (!hasNext())
                return null;

            Integer ret = nextRet;
            nextRet = null;
            return ret;
        }

        /**������Чiters��������nextRet�ĸ�ֵ
         * ����Ҫ��֤�ݵ���
         * */
        @Override
        public boolean hasNext() {
            if (nextRet!=null) //��nextRet��δ�����ѵ����������ٽ���һ��ȡ����������ڱ�֤��hasNext���ݵ���
                return true;

            //�������������ȡ��
            NestedInteger curNest;
            while (!iterStack.isEmpty()) {
                if (!iterStack.peek().hasNext()) {/*�����Чiters���������Чiter��������Դ��
                1.��һ��ȡ����Ҳ�������while���stack.peek����������
                2.����while�У�������õ��µ�iter��push֮�����iter�������һ����iter����List��iter��
                �����ڱ���while��Ҳ���ܲ�����iter�������iter����������ڱ�while֮ǰ��һ��while����
                ���ǰ����ڱ�while��������ܴ���while�����ķ�iter

                ��֮���ǲ��������ķ�iter��ֻҪpeek�Ƿϵľ�pop��Ȼ��continue
                */
                    iterStack.pop();
                    continue;
                }
                //else : iterStack.peek().hasNext
                curNest = iterStack.peek().next();
                if (curNest.isInteger()) {
                    nextRet = curNest.getInteger();
                    return true;//return֮�󱾴��õ�iter���ܻ����ϣ������´�hasNextʱ���ɱ�while����
                }
                //else : curNest is a list
                iterStack.push(curNest.getList().iterator());
            }

            //ջ��
            return false;
        }

    }

}
