/**算法分析：使用stack处理括号匹配问题
 * Tn=On Sn=On
 *
 * 往栈中压入每个括号的idx代表括号
 * 栈中永远会存在一个')'作为当前有效字串的左边界哨兵，刚开始的时候，先压入一个'-1'当做最左边的')'边界哨兵。
 * 然后从左往右扫描s，遇到(则压入栈，遇到)则与栈中进行尝试匹配。可能匹配成功（此时定有哨兵在，定非空）则计算当前有效字串长度
 * 并更新max；可能匹配失败（pop出哨兵，栈空），则压入这个多余的)当做新的哨兵。
 *
 * '('永远可压入栈，它一直等待后续的')'与其匹配，来增加当前有效字串的长度，而不会打断当前有效子串
 * ')'有两种情况：
 * 1.栈中有'('与其匹配
 * 2.栈中无'('与其匹配，那就意味着当前')'打断了当前有效子串（也是唯一打断当前有效字串的方式）
 * 此时该')'可作为新边界入栈，因为之后的串再无可能与之前的串构成有效字串了
 * */

package round1;

import java.util.Stack;

public class Q032LongestValidParentheses_Solution1 {

    public int longestValidParentheses(String s) {
        if (s==null || s.length()==0)
            return 0;

        int maxLen = 0, curLen;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else { //==')'
                stack.pop();//这里的pop可能pop出两种东西：1.与)匹配的(，栈非空；2.无(可匹配，则将哨兵pop出，栈空
                if (stack.isEmpty()) { //匹配失败，有效子串被打断
                    stack.push(i); //push入新哨兵做边界
                } else { //匹配成功，计算一次当前有效字串长度
                    maxLen = Integer.max(maxLen, i - stack.peek()); //计算当前有效字串长度并更新maxLen
                        //***bug:此时peek为当前有效子串的左边界，应该用peek，而非pop出的
                }
            }
        }
        //在前面每次匹配)之后都计算一次当前长度，无需进行剩余处理了

//        //剩余处理, 最后栈一定非空，剩下若干的'('与哨兵')'，由于这些个尚未构成一整个有效字串就提前结束了，
//        // 故每个括号之间都有一个独立的有效字串，故要依次进行处理
//        int front = stack.pop(), rear;
//        maxLen = Integer.max(maxLen, s.length()-front-1);
//        rear = front;
//        while (!stack.isEmpty()) {
//            front = stack.pop();
//            maxLen = Integer.max(maxLen, rear-front-1);
//            rear = front;
//        }
        /**这里就是与自己WA算法的最大不同！WA算法由于使用简单的cnt计数器代替栈，信息量太少，在进行剩余处理的时候无法
        * 得知最后在进行的进行中子串的有效长度是多少。而此法就不一样了 ，由于使用了一个真stack进行信息存储，将idx作为
        * element push进stack中，并适时地打断清算有效字串生成新边界，使得剩余处理变得有可能
         *
         * 再仔细一想，这种把idx push进stack，然后用完直接pop掉，计算dist的时候使用i-stack.peek()的方法，
         * 好像就是Q084柱状图问题里的stack解法的一样的思想？
        */
        return maxLen;
    }

    public static void main(String[] args) {
        Q032LongestValidParentheses_Solution1 q = new Q032LongestValidParentheses_Solution1();
        String str = ")(((((()())()()))()(()))(";
        q.longestValidParentheses(str);
    }

}
