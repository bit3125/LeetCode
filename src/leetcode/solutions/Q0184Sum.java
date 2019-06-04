package leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**算法分析：Tn = O(n^3)
 * 将问题拆解成一个个子问题：
 * 先用threeSum/TwoSum中的思路，把数组整体排序。
 * 然后使用类似ThreeSum中的方法，用一个i游标确定一个数字，然后用ThreeSum函数得到往下子数组的和数为target-nums[i]所有不重复组合
 * 关于怎么得到这么一个ThreeSumLists，当然是继续使用一个TwoSum函数用一样的思想得到。
 * 然后问题就被化为子问题，就做出来了
 *
 * 从这里得到启示：ThreeSum也可以用这种方法，用三个游标麻烦死了，还是模块化好写
 * */
public class Q0184Sum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length<=3) // exit
            return results;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            //avoid duplication
            if (i>0 && nums[i-1]==nums[i])
                continue;

            List<List<Integer>> threeSumLists = threeSum(nums, target-nums[i], i + 1, nums.length);
            for (List<Integer> threeSumList:threeSumLists){
                List<Integer> result = new ArrayList<>();
                result.add(nums[i]);
                result.addAll(threeSumList);
                results.add(result);
            }
        }

        return results;
    }


    public List<List<Integer>> threeSum(int[] nums, int target, int start, int end) {
        List<List<Integer>> results = new ArrayList<>();
        if (end-start<=2) // exit
            return results;

        for (int i = start; i < end; i++) {
            //avoid duplication
            if (i>start && nums[i-1]==nums[i])
                continue;

            List<List<Integer>> twoSumLists = twoSum(nums, target-nums[i], i + 1, end);
            for (List<Integer> twoSumList :
                    twoSumLists) {
                List<Integer> result = new ArrayList<>();
                result.add(nums[i]);
                result.addAll(twoSumList);
                results.add(result);
            }

        }

        return results;
    }

    /**传入的nums保证如下条件：1.非递减有序；2.start与end有效
     *
     * return the lists without duplication
     * */
    public List<List<Integer>> twoSum(int[] nums, int target, int start, int end) { //[,)
        List<List<Integer>> results = new ArrayList<>();
        if (end-start<=1) // exit
            return results;

        int front = start, rear = end-1;
        int sum;
        while (front < rear) { //不能是同一个数
            // avoid duplication
            if (front > start && nums[front - 1] == nums[front]) {
                front++;  //***bug:forget
                continue;
            }
            if (rear < end - 1 && nums[rear + 1] == nums[rear]) {
                rear--;
                continue;
            }

            sum = nums[front] + nums[rear];
            if ( sum == target) {
                List<Integer> result = new ArrayList<>();
                result.add(nums[front]);
                result.add(nums[rear]);
                results.add(result);
                front++; //whichever move. Dont forget
            } else if (sum < target) {
                front ++;
            } else if (sum > target) {
                rear--;
            }

        }

        return results;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

        Q0184Sum q = new Q0184Sum();
        System.out.println(q.fourSum(nums, target).size());

    }

}
