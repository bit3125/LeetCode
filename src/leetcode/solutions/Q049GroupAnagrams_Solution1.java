/**算法分析：Tn = O(n^3)~O(n^2)
 * 本质就是将所有字符串分类，装到不同的list里
 * 使用cnt来唯一确定一个类别。
 * 使用i遍历数组，去逐个匹配j是否是同类，这里有n^2的复杂度了。同时将使用过的j进行remove，这里又加了一层n的复杂度
 * 故总共介于O(n^3)~O(n^2)
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
		// TODO 自动生成的方法存根

	}

}
