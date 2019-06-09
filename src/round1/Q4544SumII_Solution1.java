package round1;


import java.util.*;

/**算法分析：如果使用4Sum的解法的话，那么复杂度是On^3。考虑优化到On^2
 * 对最后结果集中的任意一组组合，必有a+b=-(c+d)
 * 如果能针对所有的(a+b)组合找到其对应的(c+d)组合（如果存在），那么就能找到所有的解
 *
 *
 * bug：原来以为只要四个数相同就是duplication，提交后发现，ABCD取出来的数是有序性的。
 * 然后又发现他的数对(i,j,k,l)指的是下标，也就是说只要下标不一样都不是duplication....
 * */
public class Q4544SumII_Solution1 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A==null || B==null || C==null || D==null)
            return 0;

        int cnt = 0;
        Map<Integer, Integer> mapAB, mapCD;
        mapAB = twoArrayCombination(A, B);
        mapCD = twoArrayCombination(C, D);

        for (int sumAB : mapAB.keySet()) {
            int sumCD = -sumAB;
            if (!mapCD.containsKey(sumCD))
                continue;
            cnt += mapAB.get(sumAB) * mapCD.get(sumCD);
        }
        return cnt;
    }

    /**保证传入的AB数组都是非递减序的(这个好像无序也无所谓)
     * 保证return的Map中的数组也是非递减序的(先无序吧)
     * */
    public Map<Integer, Integer> twoArrayCombination(int[] A, int[] B) {

        Map<Integer, Integer> map = new HashMap<>();
        int sum;
        Integer cnt;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                sum = A[i] + B[j];
                cnt = map.get(sum);
                map.put(sum, cnt == null ? 1 : cnt + 1);
            }
        }
        return map;
    }

}
