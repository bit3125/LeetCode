package round3.q322CoinChange.solution1;

import java.util.Arrays;

/**
 * 错误解.
 * 用递归做了半天超时, 才反应过来递归的时候有大量的重复搜索,
 * 然后才反应过来这是背包问题. 太久没做忘了
 * 看Solution2吧
 *
 * */

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount == 0) {
            return 0;
        }

        return findMinCoinCnt(coins, 0, amount);
    }


    /**
     * ***BUG: 这里不能用贪心算法. 当前coin多用是局部最优解, 并不一定是全局最优解
     */
    public int findMinCoinCnt(int[] coins, int curIdx, int amount) {
        if (amount == 0) {
            return 0;
        }
        // else
        if (curIdx >= coins.length) { // illegal
            return -1;
        }

        int curCoin, curCoinCnt;
        curCoin = coins[curIdx];
        curCoinCnt = amount / curCoin; // may be 0
        int oneCnt, minCnt = Integer.MAX_VALUE;
        while (curCoinCnt >= 0) {
            oneCnt = findMinCoinCnt(coins, curIdx + 1, amount - curCoin * curCoinCnt);
            if (oneCnt >= 0) { // legal
                oneCnt += curCoinCnt;
                minCnt = Integer.min(minCnt, oneCnt);
            }

            curCoinCnt--;
        }

        //***BUG: 边界处理. 上述循环有可能最后一种组合都找不到, 所有oneCnt都非法, minCnt的初始值就不会被更新
        return minCnt == Integer.MAX_VALUE ? -1 : minCnt;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] coins = new int[]{186, 419, 83, 408};
        int amount = 6249;
        System.out.println(sl.coinChange(coins, amount));
    }
}