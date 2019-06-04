/**看Epoch1的分析就行
 * 
 * */

package leetcode.solutions;

public class Q005LongestPalindromicSubstring_Epoch2 {
	
    public String longestPalindrome(String s) {
        if (s==null || s.length()==0)
        	return "";
        
        boolean[][] f = new boolean[s.length()][s.length()];
        
        //cal
        for (int i=f.length-1;i>=0;i--)
        	for (int j=i;j<f.length;j++)
        		f[i][j] = i==j 
        		|| ( j-i==1 && s.charAt(i)==s.charAt(j) ) 
        		|| (f[i+1][j-1] && s.charAt(i)==s.charAt(j));
        
        int maxLen = Integer.MIN_VALUE;
        int curLen ;
        int targetI = 0, targetJ = 0;
        for (int i=0;i<f.length;i++){
        	for (int j=f.length-1;j>=0;j--){
        		if (f[i][j]){
        			curLen = j-i+1;
        			if (curLen>maxLen){
        				maxLen = curLen;
        				targetI = i;
        				targetJ = j;
        				break;
        			}
        		}
        	}
        }
        
        return s.substring(targetI, targetJ+1);
    }
	
	public static void main(String[] args) {
		Q005LongestPalindromicSubstring_Epoch2 q = new Q005LongestPalindromicSubstring_Epoch2();
		String s = "bananas";
		System.out.println(q.longestPalindrome(s));
	}

}
