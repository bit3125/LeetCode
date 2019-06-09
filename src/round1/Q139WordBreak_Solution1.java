/**算法分析：此处使用暴力穷举,TLE
 * Tn = O(n*m) , 其中n为字符串长度， m为dict.size()
 * 
 * Tn推导过程：
 * 设n=s.length(), l为word的平均长度, m=wordDict.size(), k为s中平均包含的word个数
 * 则Tn=O(k*m*l)=O(n/l*m*l)=O(n*m)
 * 
 * 此法TLE, 不可用
 * */


package round1;

import java.util.List;

public class Q139WordBreak_Solution1 {

	public boolean wordBreak(String s, List<String> wordDict) {
		if (s==null || s.length()==0 || wordDict==null || wordDict.size()==0)
			return false;
		
		return wordBreakCore(s, wordDict, 0, false);
	}
	
	/**
	 * Params:
	 * - curIdx: 永远指向当前未匹配的第一位
	 * */
	public boolean wordBreakCore(String s, List<String> wordDict, int curIdx, boolean hasFound){
		if (hasFound) //剪枝
			return true;
		
		if (curIdx==s.length()){//递归出口
			hasFound = true;
			return true;
		}
		
		for (String matchStr : wordDict){
			int subStrEnd = curIdx+matchStr.length();
			if (subStrEnd>s.length())
				continue;
			if ( s.substring(curIdx, subStrEnd).equals(matchStr) ){
				if (wordBreakCore(s, wordDict, subStrEnd, false))
					return true;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		String s = "abcde";
		System.out.println(s.substring(0, 6));
	}

}
