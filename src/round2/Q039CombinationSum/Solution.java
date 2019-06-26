/**�Ǳ���������
 *
 * ʹ���������ȫ���еĵݹ���ý�������
 * ÿһ��ݹ�ջ����һ��������״̬ת�Ʒ�ʽ��
 * 1. !use curIdx, -> curIdx
 * 2. !use curIdx, -> curIdx+1
 * 3. use curIdx, -> curIdx
 * 4. use curIdx, -> curIdx+1
 * ���У�1.����Ч��״̬ת�ƣ� 4.��Ч��3.+2.��
 * ��ʵ����ֻ�����2.��3.��״̬ת�Ƽ���
 *
 * all positive
 * */

package round2.Q039CombinationSum;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates==null || candidates.length==0)
            return results;

        List<Integer> curList = new ArrayList<>();
        combinationSumCore(candidates, target, 0, 0, curList, results);

        return results;
    }

    /**
     * ���뺯����curIdx����δ��ɵĶ������ʺ�����ڴ����ж��Ƕ���һ��ݹ�ջ��״̬�ж�
     * */
    private void combinationSumCore(int[] candidates, int target, int curIdx, int curSum,
                                    List<Integer> curList, List<List<Integer>> results) {
        // �ϵȵݹ�ջ��result�ж�
        if (curSum > target)
            return; // invalid
        if (curSum == target) {
            results.add(new ArrayList<>(curList));
            return;
        }

        // ��ǰ��Ҫִ�мӺ͵�Խ���ж�
        if (curIdx == candidates.length)
            return;

        // status2: do not use curIdx and transfer to next idx
        combinationSumCore(candidates, target, curIdx+1, curSum, curList, results);

        // status3: use curIdx and do not transfer
        curList.add(candidates[curIdx]);
        combinationSumCore(candidates, target, curIdx, curSum+candidates[curIdx], curList, results);
        curList.remove(curList.size() - 1); // backtracking
    }

}