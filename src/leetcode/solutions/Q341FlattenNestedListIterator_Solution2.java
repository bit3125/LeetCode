package leetcode.solutions;

import leetcode.structures.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**算法分析：果然WA的算法是可行的！稍微改改就可以了！
 *
 * 相较于Solution1，本法中的stack只保存了部分iters而非把所有数据又拷贝了一份，虽然最坏复杂度也是On但是实际上是更省空间的
 *
 * 此法主要通过两个技巧解决WA中的问题：
 * 1.使用了一个nextRet O1的空间来存储下一次next要return的数。这是个很重要的技巧，因为包裹着的NestedInteger如果
 * 是个List，是有可能为空的，必须要提前取出进行判断才能在hasNext方法中正确的判断出其为空然后return false，故要
 * 提前取数，故提前取出的数只要有一个对象能存住那么就能实现这个方法
 * 2.iters的stack不存 NestedIterator，只存List<NestedInteger>的iter（也即List容器的iter）。这样就可以简化操作，
 * 因为jdk的iter是包装好了的
 *
 * 在hasNext中进行栈中无效iter的清理并进行nextRet的赋值，并且通过取数后对nextRet置空，来保证了hasNext的幂等性
 * （discuss中的答案并没有保证其幂等性）
 *
 * hasNext中的while好好琢磨琢磨，实现了两层功能，逻辑稍微复杂点
 * */
public class Q341FlattenNestedListIterator_Solution2 {

    public class NestedIterator implements Iterator<Integer> {

        private Integer nextRet;
        private Stack<Iterator<NestedInteger>> iterStack ;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.iterStack = new Stack<>();
            this.iterStack.push(nestedList.iterator());
        }

        /**规定在每次调用next之前都会调用一次hasNext
         * 故stack中无效iters的清空、nextRet的赋值都可以交给hasNext方法
         *
         * 在取出nextRet之后要清空
         * */
        @Override
        public Integer next() {
            if (!hasNext())
                return null;

            Integer ret = nextRet;
            nextRet = null;
            return ret;
        }

        /**负责无效iters的清理与nextRet的赋值
         * 并且要保证幂等性
         * */
        @Override
        public boolean hasNext() {
            if (nextRet!=null) //若nextRet还未被消费掉，则无需再进行一次取出。这个出口保证了hasNext的幂等性
                return true;

            //否则进行清理与取数
            NestedInteger curNest;
            while (!iterStack.isEmpty()) {
                if (!iterStack.peek().hasNext()) {/*清空无效iters。这里的无效iter有两个来源：
                1.上一次取数（也是在这个while里）后，stack.peek用完作废了
                2.本次while中，在下面得到新的iter并push之后，这个iter本身就是一个废iter（空List的iter）
                由于在本次while中也可能产生废iter，故这个iter清理操作不在本while之前起一个while做，
                而是包含在本while里，这样才能处理本while产生的废iter

                总之就是不管哪来的废iter，只要peek是废的就pop掉然后continue
                */
                    iterStack.pop();
                    continue;
                }
                //else : iterStack.peek().hasNext
                curNest = iterStack.peek().next();
                if (curNest.isInteger()) {
                    nextRet = curNest.getInteger();
                    return true;//return之后本次用的iter可能会作废，留给下次hasNext时再由本while处理
                }
                //else : curNest is a list
                iterStack.push(curNest.getList().iterator());
            }

            //栈空
            return false;
        }

    }

}
