package round1;


import java.util.*;

/**�㷨���������ʹ��4Sum�Ľⷨ�Ļ�����ô���Ӷ���On^3�������Ż���On^2
 * ����������е�����һ����ϣ�����a+b=-(c+d)
 * �����������е�(a+b)����ҵ����Ӧ��(c+d)��ϣ�������ڣ�����ô�����ҵ����еĽ�
 *
 *
 * bug��ԭ����ΪֻҪ�ĸ�����ͬ����duplication���ύ���֣�ABCDȡ���������������Եġ�
 * Ȼ���ַ�����������(i,j,k,l)ָ�����±꣬Ҳ����˵ֻҪ�±겻һ��������duplication....
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

    /**��֤�����AB���鶼�Ƿǵݼ����(�����������Ҳ����ν)
     * ��֤return��Map�е�����Ҳ�Ƿǵݼ����(�������)
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
