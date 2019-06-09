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

    /**��֤�����AB���鶼�Ƿǵݼ����(�����������Ҳ����ν)
     * ��֤return��Map�е�����Ҳ�Ƿǵݼ����(�������)
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
