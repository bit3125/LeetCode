/**非暴力不合作
 *
 * 使用类似穷举全排列的递归调用进行搜索
 * 每一层递归栈向下一共有四种状态转移方式：
 * 1. !use curIdx, -> curIdx
 * 2. !use curIdx, -> curIdx+1
 * 3. use curIdx, -> curIdx
 * 4. use curIdx, -> curIdx+1
 * 其中，1.是无效的状态转移， 4.等效于3.+2.，
 * 故实际上只需进行2.与3.的状态转移即可
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
     * 进入函数的curIdx是尚未完成的动作，故函数入口处的判断是对上一层递归栈的状态判断
     * */
    private void combinationSumCore(int[] candidates, int target, int curIdx, int curSum,
                                    List<Integer> curList, List<List<Integer>> results) {
        // 上等递归栈的result判断
        if (curSum > target)
            return; // invalid
        if (curSum == target) {
            results.add(new ArrayList<>(curList));
            return;
        }

        // 当前将要执行加和的越界判断
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