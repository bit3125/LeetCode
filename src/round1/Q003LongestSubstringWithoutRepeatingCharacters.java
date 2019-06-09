package round1;
/**动态规划
 * 设f[i]为以s[i]结尾的最长不重复子串的长度
 * f[i] = 如果f[i-1]的子串中没有与s[i]重复的字符，那么f[i-1]+1，如果有那么i-lastIdxes[s[i]]
 * */

import java.util.Arrays;

public class Q003LongestSubstringWithoutRepeatingCharacters {

	public static int HASH_SIZE = 128;
	public static char HASH_BEGIN = ' ';
	
    public int lengthOfLongestSubstring(String s) {
    	if (s==null)
    		return -1;
    	if (s.length()==0)
    		return 0;
    	
        int[] f = new int[s.length()];//以s[i]结尾的最长不重复子串的长度
        int[] lastIdxes = new int[HASH_SIZE];//该字母最后一次出现的idx的位置
        
        Arrays.fill(f, 0);
        Arrays.fill(lastIdxes, -1);
        f[0] = 1;
        lastIdxes[s.charAt(0)-HASH_BEGIN] = 0;
        
        for (int i=1;i<s.length();i++){
        	if (lastIdxes[s.charAt(i)-HASH_BEGIN]<i-f[i-1])
        		f[i] = f[i-1]+1;
        	else
        		f[i] = i-lastIdxes[s.charAt(i)-HASH_BEGIN];
        	lastIdxes[s.charAt(i)-HASH_BEGIN] = i;
        }

        return max(f);
    }
    
    public int max(int[] array){
    	int max = array[0];
    	for (int n:array){
    		if (n>max)
    			max = n;
    	}
    	
    	return max;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String s = "pwwkew";
		Q003LongestSubstringWithoutRepeatingCharacters q = new Q003LongestSubstringWithoutRepeatingCharacters();
		System.out.println(q.lengthOfLongestSubstring(s));;
		
	}

}
