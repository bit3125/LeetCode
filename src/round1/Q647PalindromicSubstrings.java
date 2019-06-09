package round1;
/**算法思路：
 * 参看Q005的Solution2：二维DP
 * */

import java.util.Arrays;

public class Q647PalindromicSubstrings {

	public int countSubstrings(String s) {
    	if (s==null || s.length()==0)
    		return 0;

    	int cnt = 0;
        boolean[][] f = new boolean[s.length()][s.length()];
        for (int i=0;i<s.length();i++)
        	Arrays.fill(f[i], false);

        for (int i=s.length()-1;i>=0;i--) {
			for (int j = i; j < s.length(); j++) {
				int lenCur = j - i + 1;
				if ((lenCur == 1) || (lenCur == 2 && s.charAt(i) == s.charAt(j))
						|| (f[i + 1][j - 1] == true && s.charAt(j) == s.charAt(i))) {
					f[i][j] = true;
					cnt++;
				}
			}
		}

        return cnt;
    }
	
}
