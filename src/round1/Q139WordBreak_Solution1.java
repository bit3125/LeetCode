/**�㷨�������˴�ʹ�ñ������,TLE
 * Tn = O(n*m) , ����nΪ�ַ������ȣ� mΪdict.size()
 * 
 * Tn�Ƶ����̣�
 * ��n=s.length(), lΪword��ƽ������, m=wordDict.size(), kΪs��ƽ��������word����
 * ��Tn=O(k*m*l)=O(n/l*m*l)=O(n*m)
 * 
 * �˷�TLE, ������
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
	 * - curIdx: ��Զָ��ǰδƥ��ĵ�һλ
	 * */
	public boolean wordBreakCore(String s, List<String> wordDict, int curIdx, boolean hasFound){
		if (hasFound) //��֦
			return true;
		
		if (curIdx==s.length()){//�ݹ����
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
