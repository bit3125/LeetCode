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
public class Q4544SumII {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A==null || B==null || C==null || D==null)
            return 0;

        Set<List<Integer>> results = new HashSet<>();
        Map<Integer, List<List<Integer>>> mapAB, mapCD;
        mapAB = twoArrayCombination(A, B);
        mapCD = twoArrayCombination(C, D);

        for (int sumAB : mapAB.keySet()) {
            int sumCD = -sumAB;
            List<List<Integer>> pairABList = mapAB.get(sumAB);
            for (List<Integer> pairAB : pairABList) {
                if (!mapCD.containsKey(sumCD))
                    continue;

                List<List<Integer>> pairCDList = mapCD.get(sumCD);
                for (List<Integer> pairCD : pairCDList) {
                    List<Integer> result = new ArrayList<>();
                    result.addAll(pairAB);
                    result.addAll(pairCD);

                    results.add(result);
                }
            }

        }
        return results.size();
    }

    /**保证传入的AB数组都是非递减序的(这个好像无序也无所谓)
     * 保证return的Map中的数组也是非递减序的(先无序吧)
     * */
    public Map<Integer, List<List<Integer>>> twoArrayCombination(int[] A, int[] B) {

        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        List<Integer> pair ;
        int sum;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                pair = new ArrayList<>();
                pair.add(A[i]);
                pair.add(B[j]);
                sum = A[i] + B[j];
                if (!map.containsKey(sum)) {
                    map.put(sum, new ArrayList<>());
                }
                map.get(sum).add(pair);
            }
        }

        return map;
    }

}
