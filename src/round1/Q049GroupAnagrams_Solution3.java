/**�㷨������Tn = On
 * ��sulution2���������Ż�
 * ֻҪ������strs�������ƥ�䣬��ô���ⲻ��n^2�ĸ��Ӷȣ�
 * �ʿ��������Ա���strs��ʱ���ܹ�ֱ�ӽ�ÿ��str�ӵ���ȷ������������Ͳ���ÿ�ζ��ǱȽ�һ��str��
 * �������ӶȾ��ܽ��͵�On��
 * ��ô�����ܸ�ÿ��str�������������������أ�����Ȼ���뵽��ʹ��Hash
 * ��str�����id����26��key��toString�����ܰ�26��keyת����һ��key��ʵ��hash
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
		// TODO �Զ����ɵķ������

	}

}
