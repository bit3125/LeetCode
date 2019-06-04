package leetcode.solutions;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**算法分析：Tn=On Sn=Ok
 *
 * */

public class Q239SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums==null || nums.length==0)
            return new int[0];

        int[] result = new int[nums.length-k+1];
        Deque<Integer> posibIdxQ = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (!posibIdxQ.isEmpty() && posibIdxQ.peek() <= i - k)  //remove idx if out of bound
                posibIdxQ.removeFirst();

            while (!posibIdxQ.isEmpty() && nums[posibIdxQ.getLast()]<nums[i])  //***bug:用的Deque就不能用.peek
                //push new idx into Q, pop idxs where nums[idx]<nums[i]
                posibIdxQ.removeLast();
            posibIdxQ.addLast(i);
            if (i>=k-1) //i-k+1>=0
                result[i-k+1] = nums[posibIdxQ.getFirst()];
        }

        return result;
    }

    public static void main(String[] args) {
        Q239SlidingWindowMaximum q = new Q239SlidingWindowMaximum();
        int[] nums = new int[]{1, 3, 1, 2, 0, 5};
        int k = 3;
        System.out.println(Arrays.toString(q.maxSlidingWindow(nums, k)));;
    }

}
