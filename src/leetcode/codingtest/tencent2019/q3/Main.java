package leetcode.codingtest.tencent2019.q3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int change(int[] coins, int m) {
        if (coins[0]!=1)
            return -1;

        int cnt = 0;
        int sum = 1;
        while(sum < m){
            int i;
            for (i = 0; i < coins.length; i++) {//找到最大的面值比sum+1小的coin
                if (coins[i]>sum+1)
                    break;
            }
            sum += i-1>=0?coins[i - 1]:0;
            cnt++;
        }
        return cnt + 1;
    }

    public static void main(String[] args) {

        //input
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(), n = in.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = in.nextInt();
        }
        Arrays.sort(coins);

        //cal
        int cnt = change(coins, m);
        System.out.println(cnt);
    }

}
