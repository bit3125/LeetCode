/**�㷨������
 * ״̬���壺dp[i]��ʾs.substring(0,i+1)����i��β���ַ��Ӵ���can be segmented 
 * into a space-separated sequence of one or more dictionary words.
 * 
 * ״̬ת�Ʒ��̣�dp[i] = 1. true, if ( exist wordDict[j].equals(s.substring(startIdx, i+1)) && (startIdx==0 || dp[startIdx-1])
 * , ����startIdx = i-wordDict[j].length()+1 ��startIdx>=0 �� 2.false , if others
 * ��ʼ��������
 * 
 * Tn = O(n*m), Sn = On�� ����n=s.length(), m=wordDict.size()
 * 
 * ����ʹ�ô�dp�������Խ���Tn��ԭ�򣺶���״̬dp[i]��dp�����о�ֻ����s.substring(0,i+1)�ǲ�������������Ӵ�
 * �����ù�����ʹ�����ļ���ƥ��word���������⣬�Ӷ�����ͽ����˴����ļ�֦
 * 
 * ��Solution1��Tn��һ���ģ�Ϊʲô���AC����һ��û��AC�أ����²�����Ϊ�ʱ�临�ӶȵĹ�ϵ
 * ��Solution1���ʱ�临�Ӷ��Ǻ�����
 * */


package leetcode.codingtest.jingdong.q2;

import leetcode.solutions.Q208ImplementTrie;

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
				if (curNode == null)  //���ȵ��� || ���봮��ƥ��
					return false;
			}
			return curNode.isEnd; //���ȵ���
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
				if (curNode == null)  //���ȵ��� || ���봮��ƥ��
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
