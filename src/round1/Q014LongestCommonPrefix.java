package round1;

public class Q014LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
    	if (strs==null||strs.length==0)
    		return "";
    	int minLen = Integer.MAX_VALUE;
    	for (int i=0;i<strs.length;i++){
    		if (strs[i]==null||strs[i].length()==0)
    			return "";
    		if (strs[i].length()<minLen)
    			minLen = strs[i].length();
    	}

    	int idx;
		for (idx=0;idx<minLen;idx++){//逐位遍历
    		for (int i=0;i<strs.length-1;i++){//对所有str遍历
    			if (strs[i].charAt(idx)!=strs[i+1].charAt(idx)){
    				return strs[0].substring(0, idx);
    			}
    		}
    	}
		return strs[0].substring(0, idx);
    }
    
	public static void main(String[] args) {
		Q014LongestCommonPrefix q = new Q014LongestCommonPrefix();
//		String[] strs = {"flower","flow","flight"};
//		String[] strs = {"dog","racecar","car"};
//		String[] strs = {"","dog","cat"};
		String[] strs = {"aa","a"};
		System.out.println(q.longestCommonPrefix(strs));
	}

}
