package leetcode.solutions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**算法思路：
 * 之前打算用动态规划做，
 * 所有的新回文子串都是通过前一位置的回文子串再加上当前位置的两边夹构成的（有特殊情况，前一位置的回文子串为全同字符，则只需加上当前位置则构成新回文子串）
 * 设lens[i]为以s[i]结尾的最长回文子串长度，则状态转移方程为：
 * lens[i]= 1.len[i-1]+2, when s[i] == s[i-len[i-1]-1]
 * 			2.len[i-1]+1, when s[i] != s[i-len[i-1]-1] && allSame[i-1]==true && s[i]==s[i-1] (考虑到)
 * 			3.1, other 
 * 但是这种算法是错误的，因为当前位置的1.失败，2.也失败，不能直接跳转到3.，其还可能与前一位置的次长回文子串构成新最长回文子串
 * 
 * 故修改算法：
 * 不使用动态规划，遍历每个位置，计算并记录下每个位置的所有回文子串，并且从小到大计算（有序列表），这样最后再挑出一个最长的。
 * 要考虑特殊情况：前位置回文子串长度为1的时候，有可能s[i]与s[i-1]直接构成新回文子串，无需两边夹
 * 复杂度为O(n^2)?
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
        
        for (int i=1;i<s.length();i++){//计算以每个位置结尾的回文子串列表
        	ArrayList<Integer> substrLensPrev = substrLensLists.get(i-1);
        	ArrayList<Integer> substrLensCur = substrLensLists.get(i);
        	for (int j=0;j<substrLensPrev.size();j++){//该位置结尾的回文子串列表通过前一位置的回文子串列表计算
        		int substrLenPrev = substrLensPrev.get(j);
        		//s[i] == s[i-1]的情况
        		if (substrLenPrev==1 && s.charAt(i)==s.charAt(i-1)){
        			substrLensCur.add(2);
        		}
        		//遍历所有前位置子串
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
        	int substrLen = substrLens.get(substrLens.size()-1);//因为列表中的lens都是从小到大排序的，故最后一个就是该位置上的最长子串
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
