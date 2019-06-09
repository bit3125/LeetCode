/**算法分析：基于Q032的栈方法 （尚未AC）
 * 由于串中可能出现字母，可以等价地理解为：每个相同的括号都视为是有差别的
 * （考虑极端情况：每个括号后面都跟着不同的字符）
 *
 * 由最后留在栈中的')'边界为界，将总串分为左右两段，左段只可能包含有无效')'，右段只可能包含有无效'('。
 * 分别累计出无效左右括号的数量为m,n ，然后从左段中挑选出m个)进行剔除，右段中挑选出n个'('进行剔除
 * ，最后组合出来的字符都扔进结果set中即可。
 *
 * 其实这个算法有问题，不应该用统计redunt左右括号的计数器，因为不是说移除左段或者右段里头的括号都是一样的，是有差别的
 * ，有的make sense有的 不能。具体来说：就是针对出现冗余括号的地方，其往前延伸的最长相同字符串中的每个括号被移除是等效的
 * 比如"()())"中，最后一个)与倒二个)被移除是等效的，但是不能移除第一个)
 *
 * */

package round1;

import java.util.*;

public class Q301RemoveInvalidParentheses_Solution1_WA {

    public List<String> removeInvalidParentheses(String s) {
        List<String> results;
        if (s==null){
            results  = new ArrayList<>();
            return results;
        } else if (s.length() == 0) {
            results  = new ArrayList<>();
            results.add("");
            return results;
        }

        int redundLeft = 0, redundRight = 0;
        int boundIdx =0;

        //find boundIdx and cnt redundLeft & redundRight
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') { //***bug:s中还可能有其他字符
                stack.pop();//这里的pop可能pop出两种东西：1.与)匹配的(，栈非空；2.无(可匹配，则将哨兵pop出，栈空
                if (stack.isEmpty()) { //匹配失败，有效子串被打断
                    stack.push(i); //push入新哨兵做边界
                    redundRight++;
                } else { //匹配成功
                    //do nothing here
                }
            }//else: do nothing
        }
        while (stack.size()>=2) {
            stack.pop();
            redundLeft++;
        }
        boundIdx = stack.pop();

        //combination
            //init
        Set<String> set = new HashSet<>();
        boolean[] selected = new boolean[s.length()];
        Arrays.fill(selected, true);
            //body
        combination(set, selected, s, 0, boundIdx, redundLeft, redundRight);
        results = new ArrayList<String>(set);
        return results;
    }

    /**
     * Params:
     * selected:标记每位最后是否被选入结果串
     * boundIdx:左段中最后一个多余右括号的下标
     * remainLeft:右段中剩下的可选左括号总数
     * remainRight:左段中剩下的可选右括号总数
     * redundLeft:右段中尚要选出的多余左括号数
     * redundRight:左段中尚要选出的多余右括号数
     * */
    public void combination(Set<String> set, boolean[] selected, String s, int curIdx,
                            int boundIdx, int redundLeft, int redundRight){

        if (redundLeft<0 || redundRight<0) //超出剩余,剪枝
            return;
        else if (curIdx == s.length()) {//TODO 统一出口
            if ( !(redundLeft==0 && redundRight==0))
                return;
            //else : create string
            char[] res = new char[s.length()];
            int len = 0, idx = 0;
            while (idx < s.length()) {
                if (selected[idx]) {
                    res[len] = s.charAt(idx);
                    len++;
                }
                idx++;
            }
            set.add(new String(res, 0, len));
            return;
        }
        //else: curIdx < s.length() && redundLeft>=0 && redundRight>=0

        if (curIdx <= boundIdx) { //依然在左段
            while (s.charAt(curIdx) != ')') {//s.charAt(boundIdx)一定为')'，故不可能越界，无需越界判断
                selected[curIdx] = true; //***bug:起到一个回溯的作用
                curIdx++;
            }

            selected[curIdx] = false;
            combination(set, selected, s, curIdx + 1, boundIdx, redundLeft, redundRight-1);
            selected[curIdx] = true;
            combination(set, selected, s, curIdx + 1, boundIdx, redundLeft, redundRight);
        } else { //已到右段
            while (curIdx < s.length() && s.charAt(curIdx) != '(') { //需加上越界判断
                selected[curIdx] = true; //***bug:起到一个回溯的作用
                curIdx++;
            }
            if (curIdx == s.length()) { //直接到达最右
                combination(set, selected, s, curIdx, boundIdx, redundLeft, redundRight);
                return ; //***bug:忘写return
            }

            selected[curIdx] = false;
            combination(set, selected, s, curIdx + 1, boundIdx, redundLeft-1, redundRight);
            selected[curIdx] = true;
            combination(set, selected, s, curIdx + 1, boundIdx,redundLeft, redundRight);
        }
    }

    public String constructString(String s, boolean[] selected){
        char[] chars = new char[s.length()];
        int len = 0;
        for (int i = 0; i < selected.length; i++) {
            if (selected[i]) {
                chars[len++] = s.charAt(i);
            }
        }

        return new String(chars, 0,len);
    }

    public static void main(String[] args) {
        Q301RemoveInvalidParentheses_Solution1_WA q = new Q301RemoveInvalidParentheses_Solution1_WA();
        String s = "(a)())()";

        q.removeInvalidParentheses(s);

    }

}
