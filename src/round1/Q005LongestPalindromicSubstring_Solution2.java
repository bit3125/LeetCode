package round1;
/**算法思路：solution1的复杂度还是太高，再次尝试使用动态规划（二维）
 * 设f[i][j]表示s.substr(i,j+1)是否是回文子串
 * 则状态转移方程如下：
 * f[i][j] = (i==j){长度为1} || (j-i==1 && s[j]==s[i]){长度为2} || ( j-i>1 && f[i+1][j-1]==true && s[j]==s[i])
 * 
 * 且整个动规矩阵中i>j的部分都是无意义舍去的，故只有半个f矩阵是有效的
 * 且要注意转移方程的依赖关系来确定动规的方向，采取i递减，j递增，j优先
 * 
 * 不过复杂度依然是O(n^2)?但是runtime显著减少
 * */

import java.util.Arrays;

public class Q005LongestPalindromicSubstring_Solution2 {

	public static int MAXSIZE =1000;
    public String longestPalindrome(String s) {
    	if (s==null || s.length()==0)
    		return "";
    	
        boolean[][] f = new boolean[MAXSIZE][MAXSIZE];
        for (int i=0;i<s.length();i++){
        	Arrays.fill(f[i], false);
        }
        
        int maxLen=-1;
        int targetI = -1, targetJ = -1;
        for (int i=s.length()-1;i>=0;i--){
        	for (int j=i;j<s.length();j++){
        		int lenCur = j-i+1;
        		if ( (lenCur==1) || (lenCur==2 && s.charAt(i)==s.charAt(j)) 
        				|| (f[i+1][j-1]==true && s.charAt(j)==s.charAt(i)) ){
        			f[i][j] = true;
        			if (lenCur>maxLen){
        				maxLen = lenCur;
            			targetI = i;
            			targetJ = j;
        			}
        		}
        	}
        }
//        int maxLen=-1;
//        int targetI = -1, targetJ = -1;
//        for (int i=0;i<s.length();i++){
//        	for (int j=s.length()-1;j>=0;j--){//由大到小开始搜索当前行i的最大长度
//        		int lenCur = j-i;
//        		if (lenCur<=maxLen)//直接跳出当前列的搜索
//        			break;
//        		if (f[i][j]){
//        			maxLen = lenCur;
//        			targetI = i;
//        			targetJ = j;
//        		}
//        	}
//        }
        
        return s.substring(targetI, targetJ+1);
    }
	
	public static void main(String[] args) {
		Q005LongestPalindromicSubstring_Solution1 q = new Q005LongestPalindromicSubstring_Solution1();
		String s = "bananas";
		System.out.println(q.longestPalindrome(s));
	}

}
