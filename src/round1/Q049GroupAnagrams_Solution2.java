/**算法分析： Tn = O(n^2)
 * solution1中为了不产生重复的result，对list使用了remove，增加了一层n的复杂度
 * 这里考虑使用一个visited辅助数组进行标记，不对ArrayList进行remove
 * 故理论复杂度O(n^2)
 * */

package round1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q049GroupAnagrams_Solution2 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs==null)
        	return null;
        
        List<List<String>> results = new ArrayList<>();
        boolean[] added = new boolean[strs.length];
        Arrays.fill(added, false);
    	for (int i=0;i<strs.length;i++){
    		if (added[i])
    			continue;
    		List<String> res = new ArrayList<>();
    		res.add(strs[i]);
    		added[i] = true;
    		int[] cnt1 = cntLetters(strs[i]);
    		for (int j=i+1;j<strs.length;j++){
    			int[] cnt2 = cntLetters(strs[j]);
    			if ( isAnagrams(cnt1, cnt2) && !added[j] ){
    				res.add(strs[j]);
    				added[j] = true;
    			}
    		}
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
		// TODO 自动生成的方法存根

	}

}
