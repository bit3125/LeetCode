package leetcode.solutions;

import java.util.Arrays;
import java.util.Random;

/**算法分析：Tn=On Sn=On
 * 最终使用了Fisher Yates算法，经典的在Tn=On下求随机排列的方法
 * 本方法的特点就是，能够通过n次的选取，使用范围在[0,n)中的随机数求出随机排列
 * 上一个方法使用的是取多次nextPermutation的方法，由于permutation的总数可能巨大
 * ，故使用的随机数取值会溢出int范围，故失效。
 *
 * 题目的without duplicates刚开始理解为不能给数组做一份拷贝，后来怎么想都想不出Sn=O1的办法
 * 现在想来可能是nums中没有重复数字的意思。。。
 * */

public class Q384ShuffleanArray {
    class Solution {
        private int[] nums;
        private Random rand;

        public Solution(int[] nums) {
            this.nums = nums;
            this.rand = new Random();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return this.nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] ret = Arrays.copyOf(nums,nums.length);
            int boundIdx = nums.length-1;
            int randIdx;
            while (boundIdx>0) {
                randIdx = rand.nextInt(boundIdx+1);
                swap(ret, randIdx, boundIdx);
                boundIdx--;
            }
            return ret;
        }

        private void swap(int[] data, int idx1, int idx2) {
            int tmp = data[idx1];
            data[idx1] = data[idx2];
            data[idx2] = tmp;
        }

    }

}
