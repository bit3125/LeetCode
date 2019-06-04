package leetcode.solutions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**�㷨˼·��
 * ֮ǰ�����ö�̬�滮����
 * ���е��»����Ӵ�����ͨ��ǰһλ�õĻ����Ӵ��ټ��ϵ�ǰλ�õ����߼й��ɵģ������������ǰһλ�õĻ����Ӵ�Ϊȫͬ�ַ�����ֻ����ϵ�ǰλ���򹹳��»����Ӵ���
 * ��lens[i]Ϊ��s[i]��β��������Ӵ����ȣ���״̬ת�Ʒ���Ϊ��
 * lens[i]= 1.len[i-1]+2, when s[i] == s[i-len[i-1]-1]
 * 			2.len[i-1]+1, when s[i] != s[i-len[i-1]-1] && allSame[i-1]==true && s[i]==s[i-1] (���ǵ�)
 * 			3.1, other 
 * ���������㷨�Ǵ���ģ���Ϊ��ǰλ�õ�1.ʧ�ܣ�2.Ҳʧ�ܣ�����ֱ����ת��3.���仹������ǰһλ�õĴγ������Ӵ�������������Ӵ�
 * 
 * ���޸��㷨��
 * ��ʹ�ö�̬�滮������ÿ��λ�ã����㲢��¼��ÿ��λ�õ����л����Ӵ������Ҵ�С������㣨�����б����������������һ����ġ�
 * Ҫ�������������ǰλ�û����Ӵ�����Ϊ1��ʱ���п���s[i]��s[i-1]ֱ�ӹ����»����Ӵ����������߼�
 * ���Ӷ�ΪO(n^2)?
 * 
 * */

public class Q005LongestPalindromicSubstring_Solution1 {
	
    public String longestPalindrome(String s) {
    	if (s==null || s.length()==0)
    		return "";
    	
        ArrayList<ArrayList<Integer>> substrLensLists = new ArrayList<ArrayList<Integer>>();
        for (int i=0;i<s.length();i++){
        	ArrayList<Integer> tmpl = new ArrayList<Integer>();
        	tmpl.add(1);
        	substrLensLists.add(tmpl);
        }
        
        for (int i=1;i<s.length();i++){//������ÿ��λ�ý�β�Ļ����Ӵ��б�
        	ArrayList<Integer> substrLensPrev = substrLensLists.get(i-1);
        	ArrayList<Integer> substrLensCur = substrLensLists.get(i);
        	for (int j=0;j<substrLensPrev.size();j++){//��λ�ý�β�Ļ����Ӵ��б�ͨ��ǰһλ�õĻ����Ӵ��б����
        		int substrLenPrev = substrLensPrev.get(j);
        		//s[i] == s[i-1]�����
        		if (substrLenPrev==1 && s.charAt(i)==s.charAt(i-1)){
        			substrLensCur.add(2);
        		}
        		//��������ǰλ���Ӵ�
        		int startOfLastSubStr = i-substrLenPrev-1;
        		if ( startOfLastSubStr>=0 && s.charAt(i)==s.charAt(startOfLastSubStr) ){//***bug
        			substrLensCur.add(substrLenPrev+2);
            		
            	}
            }
        }
        
        int maxLen = -1;
        int targetEndIdx = -1;
        for (int i=0;i<substrLensLists.size();i++){
        	ArrayList<Integer> substrLens = substrLensLists.get(i);
        	int substrLen = substrLens.get(substrLens.size()-1);//��Ϊ�б��е�lens���Ǵ�С��������ģ������һ�����Ǹ�λ���ϵ���Ӵ�
    		if (substrLen>maxLen){
    			maxLen = substrLen;
    			targetEndIdx = i;
    		}
        }        	
        	
        return s.substring(targetEndIdx-maxLen+1, targetEndIdx+1);
    }
    
	public static void main(String[] args) {
		Q005LongestPalindromicSubstring_Solution1 q = new Q005LongestPalindromicSubstring_Solution1();
		String s = "bananas";
		System.out.println(q.longestPalindrome(s));
	}

}
