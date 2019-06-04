package leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**�㷨������Tn = O(n^3)
 * ���������һ���������⣺
 * ����threeSum/TwoSum�е�˼·����������������
 * Ȼ��ʹ������ThreeSum�еķ�������һ��i�α�ȷ��һ�����֣�Ȼ����ThreeSum�����õ�����������ĺ���Ϊtarget-nums[i]���в��ظ����
 * ������ô�õ���ôһ��ThreeSumLists����Ȼ�Ǽ���ʹ��һ��TwoSum������һ����˼��õ���
 * Ȼ������ͱ���Ϊ�����⣬����������
 *
 * ������õ���ʾ��ThreeSumҲ���������ַ������������α��鷳���ˣ�����ģ�黯��д
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

    /**�����nums��֤����������1.�ǵݼ�����2.start��end��Ч
     *
     * return the lists without duplication
     * */
    public List<List<Integer>> twoSum(int[] nums, int target, int start, int end) { //[,)
        List<List<Integer>> results = new ArrayList<>();
        if (end-start<=1) // exit
            return results;

        int front = start, rear = end-1;
        int sum;
        while (front < rear) { //������ͬһ����
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
