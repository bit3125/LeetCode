/**算法分析：
 * 状态定义：dp[i]表示s.substring(0,i+1)（以i结尾的字符子串）can be segmented 
 * into a space-separated sequence of one or more dictionary words.
 * 
 * 状态转移方程：dp[i] = 1. true, if ( exist wordDict[j].equals(s.substring(startIdx, i+1)) && (startIdx==0 || dp[startIdx-1])
 * , 其中startIdx = i-wordDict[j].length()+1 且startIdx>=0 ； 2.false , if others
 * 初始条件：无
 * 
 * Tn = O(n*m), Sn = On， 其中n=s.length(), m=wordDict.size()
 * 
 * 分析使用此dp方法可以降低Tn的原因：定义状态dp[i]后，dp过程中就只关心s.substring(0,i+1)是不是满足题意的子串
 * 而不用管它是使用了哪几个匹配word来满足题意，从而本身就进行了大量的剪枝
 * 
 * 跟Solution1的Tn是一样的，为什么这个AC了上一个没有AC呢？？猜测是因为最坏时间复杂度的关系
 * ，Solution1的最坏时间复杂度是很糟糕的
 * */


package others.codingtest.jingdong.q2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	class Trie {

		boolean isEnd;
		Map<Character, Trie> sons;

		public Trie() {
			sons = new HashMap<>();
			isEnd = false;
		}

		/**
		 * Inserts a word into the trie.
		 */
		public void insert(String word) {
			if (word.length() == 0)
				return;

			Trie curNode = this, nextNode;
			char c;
			for (int i = 0; i < word.length(); i++) {
				c = word.charAt(i);
				nextNode = curNode.sons.get(c);
				if (nextNode == null) { //doesn't contain
					nextNode = new Trie();
					curNode.sons.put(c, nextNode);
				}
				curNode = nextNode;
			}
			curNode.isEnd = true;
		}

		/**
		 * Returns if the word is in the trie.
		 */
		public boolean search(String word) {
			if (word.length() == 0)
				return false;

			Trie curNode = this, nextNode;
			char c;
			for (int i = 0; i < word.length(); i++) {
				c = word.charAt(i);
				curNode = curNode.sons.get(c);
				if (curNode == null)  //树先到底 || 树与串不匹配
					return false;
			}
			return curNode.isEnd; //串先到底
		}

		/**
		 * Returns if there is any word in the trie that starts with the given prefix.
		 */
		public boolean startsWith(String prefix) {
			if (prefix.length() == 0)
				return false;

			Trie curNode = this;
			char c;
			for (int i = 0; i < prefix.length(); i++) {
				c = prefix.charAt(i);
				curNode = curNode.sons.get(c);
				if (curNode == null)  //树先到底 || 树与串不匹配
					return false;
			}
			return true;
		}

	}

	public boolean wordBreak(String s, List<String> wordDict) {
		if (s==null || s.length()==0 || wordDict==null || wordDict.size()==0)
			return false;
		
		boolean[] dp = new boolean[s.length()];
		Arrays.fill(dp, false);
		
		for (int i=0;i<dp.length;i++){
			for (String matchStr : wordDict){
				int startIdx = i-matchStr.length()+1;
				if (startIdx<0) //***bug:
					continue;
				if ( (startIdx==0 || dp[startIdx-1]) && matchStr.equals(s.substring(startIdx, i+1))){
					dp[i] = true;
					break;
				}
			}
		}
		
		return dp[dp.length-1];
	}

//	public int mostSubstring(String t, String[] strs) {
//
//		//construct trie
//		Trie trie = new Trie();
//		for (int i = 0; i < strs.length; i++) {
//			trie.insert(strs[i]);
//		}
//
//
//
//
//	}
	
	public static void main(String[] args) {
		String s = "abcde";
		System.out.println(s.substring(0, 6));
	}

}
