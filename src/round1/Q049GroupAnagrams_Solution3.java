/**算法分析：Tn = On
 * 对sulution2继续进行优化
 * 只要对整个strs进行逐对匹配，那么就免不了n^2的复杂度，
 * 故考虑在线性遍历strs的时候，能够直接将每个str扔到正确的篮子里，这样就不用每次都是比较一个str对
 * 这样复杂度就能降低到On。
 * 怎么做才能给每个str的类别能做到随机访问呢？很自然的想到，使用Hash
 * 将str的身份id——26个key给toString，就能把26个key转化成一个key，实现hash
 *   
 * */

package round1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q049GroupAnagrams_Solution3 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs==null)
        	return null;
        
        Map<String, List<String>> results = new HashMap<>();
        
    	for (int i=0;i<strs.length;i++){
    		String hashStr = getHashString(strs[i]);
    		List<String> result = results.getOrDefault(hashStr, new ArrayList<>());
    		result.add(strs[i]);
    		results.put(hashStr, result);
    	}
        
    	return new ArrayList<>(results.values());
    }
    
    public String getHashString(String str){
    	int[] cnt = new int[26];
    	Arrays.fill(cnt, 0);
    	for (int i=0;i<str.length();i++){
    		cnt[str.charAt(i)-'a']++;
    	}
    	return Arrays.toString(cnt);
    }
    
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
