/**�㷨������Tn = O(n^3)~O(n^2)
 * ���ʾ��ǽ������ַ������࣬װ����ͬ��list��
 * ʹ��cnt��Ψһȷ��һ�����
 * ʹ��i�������飬ȥ���ƥ��j�Ƿ���ͬ�࣬������n^2�ĸ��Ӷ��ˡ�ͬʱ��ʹ�ù���j����remove�������ּ���һ��n�ĸ��Ӷ�
 * ���ܹ�����O(n^3)~O(n^2)
 * */

package leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q049GroupAnagrams_Solution1 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs==null)
        	return null;
        
        List<List<String>> results = new ArrayList<>();
        List<String> strsList = new ArrayList<>(Arrays.asList(strs));
    	for (int i=0;i<strsList.size();i++){
    		List<String> res = new ArrayList<>();
    		res.add(strsList.get(i));
    		int[] cnt1 = cntLetters(strsList.get(i));
    		for (int j=i+1;j<strsList.size();j++){
    			int[] cnt2 = cntLetters(strsList.get(j));
    			if ( isAnagrams(cnt1, cnt2) ){
    				res.add(strsList.get(j));
    				strsList.remove(j);
    				j--;
    			}
    		}
    		strsList.remove(i);
    		i--;
    		
    		results.add(res);
    	}
        
    	return results;
    }
    
    public int[] cntLetters(String str){
    	int[] cnt = new int[26];
    	Arrays.fill(cnt, 0);
    	for (int i=0;i<str.length();i++){
    		cnt[str.charAt(i)-'a']++;
    	}
    	
    	return cnt;
    }
    
    public boolean isAnagrams(int[] cnt1, int[] cnt2){
    	for (int i=0;i<cnt1.length;i++){
    		if (cnt1[i]!=cnt2[i])
    			return false;
    	}
    	return true;
    }
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
