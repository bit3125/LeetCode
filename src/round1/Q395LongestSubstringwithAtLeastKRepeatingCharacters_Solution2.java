package round1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**�㷨������������Ӧ���������� Tn = Onlogn ����϶���On^2��, Sn = O(logn)������ʵ����Ч����Ⱥ������֪��Ϊɶ
 *
 * �ҳ���ǰ�Ӵ���û���k���ַ����Դ�Ϊ�ָ����ָ�������Ӵ���Ȼ��ݹ�ͳ�ơ�
 * */
public class Q395LongestSubstringwithAtLeastKRepeatingCharacters_Solution2 {

    public int longestSubstring(String s, int k) {
        if (s==null || s.length()==0)
            return 0;

        return longestSubstring(s.toCharArray(), k, 0, s.length());
    }

    public int longestSubstring(char[] s, int k, int start, int end) {
        if (end-start<k) //***bug:start>=end ��֦�ݹ����
            return 0;

        //cnt
        int[] cnts = new int[26];
        Arrays.fill(cnts, 0);
        for (int i = start; i < end; i++)
            cnts[s[i] - 'a']++;

        //***bug:stackOverFlow, ������������ĵݹ����
        int appearAndLessThanK = 0;
        for (int i = 0; i < 26; i++)
            if (cnts[i]!=0 && cnts[i]<k)
                appearAndLessThanK++;
        if (appearAndLessThanK==0)
            return end-start;

        int maxLen = 0;
        int front = start, rear = start;
        while (rear<=end) {
            if (rear == end || cnts[s[rear] - 'a'] < k) { //ע�������rear==end��ͬʱ������ĩβʣ��������ͬʱӰ����while���ж�����
                maxLen = Integer.max(maxLen, longestSubstring(s, k, front, rear));
                front = rear+1;
            }
            rear++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "aaabb";
        int k = 3;
        Q395LongestSubstringwithAtLeastKRepeatingCharacters_Solution2 q = new Q395LongestSubstringwithAtLeastKRepeatingCharacters_Solution2();

        System.out.println(q.longestSubstring(s, k));
    }

}
