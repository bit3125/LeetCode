/**算法分析：
 *
 * 使用Brute force的话是On^3的复杂度，虽然不能这么做但是提供了一个思路：对所有可能的子串判断其是否match
 * 唯一需要改进的地方就是：对搜索过程进行剪枝，缩小搜索空间
 *
 * 故可使用以下的思路：
 * 声明两个游标front rear，每次迭代就是判断substring(front, rear+1)是否match
 * 声明一个cnter数组，用来累加当前子串的字符数（大概）
 * 首先搜索以0开头的最短match子串，不断move rear on 直到当前子串match，则当前子串即为以idx0开头的最短match子串，往后的已经不用再搜索了
 * 接下来搜索以1, 2, 3...开头的最短match子串。move front on，若当前子串match，则为以1开头的最短match子串（直接把rear大于当前的情况全给剪枝了），接着move front on来搜索以2, 3...开头的情况直到子串不match
 * 以此类推，则可以用On的复杂度搜索完所有的搜索空间
 *
 * 类似这种双游标的思路，很多题都出现过（暂时记不起来。。），都是用来剪枝的
 *
 * */

package round2.Q076MinimumWindowSubstring.solution1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public String minWindow(String s, String t) {
        if (s==null || t==null)
            return null;
        if (t.length()==0)
            return "";

        Map<Character, Integer> requiredMap = new HashMap<>();
        Set<Character> requiredSet = new HashSet<>();
        char curChar;
        for (int i = 0; i < t.length(); i++) {
            curChar = t.charAt(i);
            requiredMap.put(curChar, requiredMap.getOrDefault(curChar, 0)+1); // only represents existing or not
        }
        requiredSet.addAll(requiredMap.keySet());

        int minLen = Integer.MAX_VALUE, minFrontIdx=-1, minRearIdx=-1, curLen; //todo
        int front = 0, rear = 0;
        while (rear < s.length()) { // rear++完这里也要判断一次
            while (rear<s.length()) { // move rear on, util s.substring(front, rear+1) containsAll(requiredMap). Add char(rear) every iter
                curChar = s.charAt(rear);
                if (requiredMap.containsKey(curChar)){
                    requiredMap.put(curChar, requiredMap.get(curChar) - 1);
                    if (requiredMap.get(curChar)<=0)
                        requiredSet.remove(curChar);
                    if (containsAll(requiredSet)) {
                        curLen = rear-front+1;
                        if (curLen < minLen) {
                            minFrontIdx = front;
                            minRearIdx = rear;
                            minLen = curLen;
                        }
                        break; // s.substring(front, rear+1) contains all chars}
                    }
                } // else: requiredMap do not contains curChar, do nothing

                rear++;
            }
            if (rear == s.length()) // rear++完这里要判断一次
                break; // 已经可以确定后面待搜索的子串都不会满足条件

            while (front<rear) { // move front on, util s.substring(front, rear+1) !containsAll(requiredMap). remove char(front) every iter
                curChar = s.charAt(front); // to be remove from substring
                front++; // place it here
                if (requiredMap.containsKey(curChar)) {
                    requiredMap.put(curChar, requiredMap.get(curChar) + 1);
                    if (requiredMap.get(curChar) > 0) {
                        requiredSet.add(curChar);
                    }
                }
                if (containsAll(requiredSet)) { //***bug: 与move rear on的while里头不一样，要放在上个if的外头
                    curLen = rear-front+1;
                    if (curLen < minLen) {
                        minFrontIdx = front;
                        minRearIdx = rear;
                        minLen = curLen;
                    }
                } else {
                    break;
                }
            }
            // if (front==rear) // do nothing
            rear++; // 给下轮while来add
        }

        return minFrontIdx==-1?"":s.substring(minFrontIdx, minRearIdx+1);
    }

    private boolean containsAll(Set<Character> requiredSet) {
        return requiredSet.isEmpty();
    }

}

