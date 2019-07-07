/**�㷨������
 *
 * ʹ��Brute force�Ļ���On^3�ĸ��Ӷȣ���Ȼ������ô�������ṩ��һ��˼·�������п��ܵ��Ӵ��ж����Ƿ�match
 * Ψһ��Ҫ�Ľ��ĵط����ǣ����������̽��м�֦����С�����ռ�
 *
 * �ʿ�ʹ�����µ�˼·��
 * ���������α�front rear��ÿ�ε��������ж�substring(front, rear+1)�Ƿ�match
 * ����һ��cnter���飬�����ۼӵ�ǰ�Ӵ����ַ�������ţ�
 * ����������0��ͷ�����match�Ӵ�������move rear on ֱ����ǰ�Ӵ�match����ǰ�Ӵ���Ϊ��idx0��ͷ�����match�Ӵ���������Ѿ�������������
 * ������������1, 2, 3...��ͷ�����match�Ӵ���move front on������ǰ�Ӵ�match����Ϊ��1��ͷ�����match�Ӵ���ֱ�Ӱ�rear���ڵ�ǰ�����ȫ����֦�ˣ�������move front on��������2, 3...��ͷ�����ֱ���Ӵ���match
 * �Դ����ƣ��������On�ĸ��Ӷ����������е������ռ�
 *
 * ��������˫�α��˼·���ܶ��ⶼ���ֹ�����ʱ�ǲ�����������������������֦��
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
        while (rear < s.length()) { // rear++������ҲҪ�ж�һ��
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
            if (rear == s.length()) // rear++������Ҫ�ж�һ��
                break; // �Ѿ�����ȷ��������������Ӵ���������������

            while (front<rear) { // move front on, util s.substring(front, rear+1) !containsAll(requiredMap). remove char(front) every iter
                curChar = s.charAt(front); // to be remove from substring
                front++; // place it here
                if (requiredMap.containsKey(curChar)) {
                    requiredMap.put(curChar, requiredMap.get(curChar) + 1);
                    if (requiredMap.get(curChar) > 0) {
                        requiredSet.add(curChar);
                    }
                }
                if (containsAll(requiredSet)) { //***bug: ��move rear on��while��ͷ��һ����Ҫ�����ϸ�if����ͷ
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
            rear++; // ������while��add
        }

        return minFrontIdx==-1?"":s.substring(minFrontIdx, minRearIdx+1);
    }

    private boolean containsAll(Set<Character> requiredSet) {
        return requiredSet.isEmpty();
    }

}

