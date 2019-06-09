package others.codingtest.jingdong.q22;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public int mostSubstr(String t, String[] strs) {
        if (false)//TODO
            return 0;

        int[] dp = new int[t.length()+1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 1;
        int subStartBefore ;
        for (int i = 1; i < dp.length; i++) {//i 表示+1过的下标（在dp[]中的）
            for (int j = 0; j < strs.length; j++) {
                subStartBefore = i - strs[j].length();//+1过的下标（在dp[]中的）
                if ( subStartBefore >= 0 && strs[j].equals( t.substring(subStartBefore+1-1, i+1-1)) ) {
                    dp[i] = Integer.max(dp[i], dp[subStartBefore]);
                }
            }

        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Integer.max(max, dp[i]);
        }
        return max;
    }

//    public boolean isOneOfStrs(String subt, String[] strs) {
//        for (int i = 0; i < strs.length; i++) {
//            if (subt.equals(strs[i]))
//                return true;
//        }
//        return false;
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        in.nextLine();

        String[] strs = new String[m];
        String t ;
        for (int i = 0; i < m ; i++) {
            strs[i] = in.nextLine();
        }
        t = in.nextLine();

//        //debug
//        System.out.println(m);
//        for (int i = 0; i < m - 1; i++) {
//            System.out.println(strs[i]);
//
//        }
//        System.out.println(t);

        int cnt ;
        Main main = new Main();

        cnt = main.mostSubstr(t, strs);
        System.out.println(cnt);
    }

}
