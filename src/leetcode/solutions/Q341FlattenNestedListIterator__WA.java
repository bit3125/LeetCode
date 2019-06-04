package leetcode.solutions;

import leetcode.structures.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 之前还以为不能用辅助空间进行存储。所以使用嵌套迭代器模式，但是失败了
 *
 * 先假设NestedInteger不可能为空=>并不！若是Integer则保证非null，若是List则可能是空List....
 * 故此法WA（否则就A了）
 * 但是我认为这个小bug是可以解决的
 * 但是我不知道该怎么写，算了
 */
public class Q341FlattenNestedListIterator__WA {
    public class NestedIterator implements Iterator<Integer> {
        private List<NestedInteger> data;
        private int curIdx; //尚未使用的元素的idx
        private Stack<NestedIterator> itersStack;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.data = nestedList;
            this.curIdx = 0;
            this.itersStack = new Stack<>();
        }

        /**假定标准：只有当hasNext为true的情况下才会调用next
         * 故调用next的时候则默认hasNext=true
         *
         * */
        @Override
        public Integer next() {
            if (!hasNext())
                return null;

            if (itersStack.isEmpty()) { //栈空则取数或迭代器
                NestedInteger curNest = data.get(curIdx);
                curIdx++;
                if (curNest.isInteger()) {
                    return curNest.getInteger();//is Integer，curIdx++ then return
                } else { //curNest is list
                    itersStack.push(new NestedIterator(curNest.getList()));
                }
            }
            // 未return则使用迭代器（到达此处则stack必不为空，且stack中仅剩有效迭代器）
            //去除无用迭代器的工作交给hasNext来做
            //而next在开头必调用hasNext，故可以保证在调用next方法之前，itersStack中所有的迭代器都是有效的

            return itersStack.peek().next();
        }

        /**要负责清除stack中所有的无效迭代器，
         * 然后return 是否有next
         * */
        @Override
        public boolean hasNext() {
            while (!itersStack.isEmpty() && !itersStack.peek().hasNext()) //去除无用迭代器
                itersStack.pop();
            return curIdx < data.size() || !itersStack.isEmpty();
        }
    }

}