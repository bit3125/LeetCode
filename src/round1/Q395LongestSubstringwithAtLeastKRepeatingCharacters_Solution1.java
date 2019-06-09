package round1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**�㷨������BruteForce, Tn = On^2, Sn = O1;
 * ����������
 * */
public class Q395LongestSubstringwithAtLeastKRepeatingCharacters_Solution1 {

    public int longestSubstring(String s, int k) {
        if (s==null || s.length()==0)
            return 0;

        int[] cnts = new int[26];
        Arrays.fill(cnts, 0);
        Set<Character> appearAndLessThanK = new HashSet<>();
        int maxLen = 0;

        int i = 0, cntIdx;
        char curChar;
        while (i<s.length()) {
            for (int j = i; j < s.length(); j++) { //add j
                curChar = s.charAt(j);
                cntIdx = curChar - 'a';
                cnts[cntIdx]++;
                if (1 == cnts[cntIdx] )  //��һ�γ��� //***bug:�������kΪ1ʱ�ı߽����
                    appearAndLessThanK.add(curChar);
                if (cnts[cntIdx] == k)  //�մﵽ�ͱ�
                    appearAndLessThanK.remove(curChar);

                if (appearAndLessThanK.isEmpty())
                    maxLen = Integer.max(maxLen, j-i+1);
            }

            i++; //remove i
            if (i>=s.length())
                break;
            curChar = s.charAt(i-1);
            cntIdx = curChar - 'a';
            cnts[cntIdx]--;
            if ( k-1 == cnts[cntIdx])  //�����ͱ�
                appearAndLessThanK.add(curChar);
            if ( 0 == cnts[cntIdx])  //��ȫ��ʧ
                appearAndLessThanK.remove(curChar);
            if (appearAndLessThanK.isEmpty())
                maxLen = Integer.max(maxLen, s.length()-i);

            for (int j = s.length()-1; j >= i; j--) { //remove j
                curChar = s.charAt(j);
                cntIdx = curChar - 'a';
                cnts[cntIdx]--;
                if ( k-1 == cnts[cntIdx])  //�����ͱ�
                    appearAndLessThanK.add(curChar);
                if ( 0 == cnts[cntIdx])  //��ȫ��ʧ
                    appearAndLessThanK.remove(curChar);

                if (appearAndLessThanK.isEmpty())
                    maxLen = Integer.max(maxLen, j-i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Q395LongestSubstringwithAtLeastKRepeatingCharacters_Solution1 q = new Q395LongestSubstringwithAtLeastKRepeatingCharacters_Solution1();
//        String s = "weitong";
//        int k = 2;
        String s = "a";
        int k = 1;
        System.out.println(q.longestSubstring(s, k));
    }

}
