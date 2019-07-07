/**Solution2使用int[]与int来代替HashMap与HashSet，时间开销显著减少
 *
 * */
package round2.Q076MinimumWindowSubstring.solution2;

import java.util.*;

class Solution {
    public static final int MAX_SIZE = 128;
    public String minWindow(String s, String t) {
        if (s==null || t==null)
            return null;
        if (t.length()==0)
            return "";

        int[] requiredMap = new int[MAX_SIZE]; // 目前需要的字符个数，MIN_VALUE表示t中不包含
        Arrays.fill(requiredMap, Integer.MIN_VALUE);
        int requiredCharNum = 0; // 目前还需要的字符种类数
        char curChar;
        for (int i = 0; i < t.length(); i++) {
            curChar = t.charAt(i);
            requiredMap[curChar] = requiredMap[curChar]==Integer.MIN_VALUE?1:requiredMap[curChar]+1;
            if (requiredMap[curChar]==1)
                requiredCharNum++;
        }

        int minLen = Integer.MAX_VALUE, minFrontIdx=-1, minRearIdx=-1, curLen; //todo
        int front = 0, rear = 0;
        while (rear < s.length()) { // rear++完这里也要判断一次
            while (rear<s.length()) { // move rear on, util s.substring(front, rear+1) containsAll(requiredMap). Add char(rear) every iter
                curChar = s.charAt(rear);
                if (requiredMap[curChar]!=Integer.MIN_VALUE){ //t contains curChar
                    requiredMap[curChar]--;
                    if (requiredMap[curChar]==0)
                        requiredCharNum--;
                    if (containsAll(requiredCharNum)) {
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
                if (requiredMap[curChar]!=Integer.MIN_VALUE) {
                    requiredMap[curChar]++;
                    if (requiredMap[curChar] == 1) {
                        requiredCharNum++;
                    }
                }
                if (containsAll(requiredCharNum)) { //***bug: 与move rear on的while里头不一样，要放在上个if的外头
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

    private boolean containsAll(int requiredCharNum) {
        return requiredCharNum<=0;
    }
}

