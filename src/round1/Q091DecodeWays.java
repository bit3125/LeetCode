package round1;

import java.util.Arrays;

/**算法分析：dp, Tn = On, Sn = On （可优化到O1）
 * dp[i] = s.charAt(i)!='0'?dp[i-1]:0 + ( s.charAt(i-1)!='0'?(0<s.substring(i-1,i+1)<=26?(i-2>=0?dp[i-2]:1):0):0 )
 *
 * */
public class Q091DecodeWays {

    public int numDecodings(String s) {
        if (s==null || s.length()==0 || s.charAt(0)=='0')
            return 0;

        //s.charAt(0)!='0'
        int[] dp = new int[s.length()];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            dp[i] = ( s.charAt(i)!='0'?dp[i-1]:0 );
            if (s.charAt(i-1)=='0')
                continue;
            int prevNum = Integer.valueOf(s.substring(i-1,i+1));
            if (0<prevNum && prevNum<=26)
                dp[i] += i-2>=0?dp[i-2]:1;
            //***bug:s.charAt(i)!=0 以及 三目运算符要整体+括号
        }

        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        String s = "01";
        Q091DecodeWays q = new Q091DecodeWays();
        System.out.println(q.numDecodings(s));;

    }

}
