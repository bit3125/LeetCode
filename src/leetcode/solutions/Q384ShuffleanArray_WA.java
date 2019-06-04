package leetcode.solutions;

import java.util.Arrays;
import java.util.Random;

public class Q384ShuffleanArray_WA {

    class Solution{

        private int[] nums ;
        private int cnt;
        private int maxCnt;
        private Random random;

        public Solution(int[] nums) {
            this.nums = Arrays.copyOf(nums, nums.length);
            this.cnt = 0;
            this.maxCnt = 1;
            for (int i = 1; i <= nums.length; i++) {
                this.maxCnt *= i;
            }
            this.random = new Random();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            shuffle((maxCnt - cnt%maxCnt) % maxCnt);
            return this.nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int shuffleTimes = random.nextInt(maxCnt);
            shuffle(shuffleTimes);
            return this.nums; //return Arrays.copyOf(this.nums, this.nums.length);
        }

        private void shuffle(int shuffleTimes) {
            this.cnt += shuffleTimes; //***bug:别等到0了再+
            while (shuffleTimes > 0) {
                if (!nextPermutationCore(nums, 0))  //非递增状态
                    reverse(nums);
                shuffleTimes--;
            }
        }

        /**用于得到idx位开始(inclusive)的子串的next全排列
         *
         * return : 是否成功得到
         * 定义s[i,len]为nums.substring(i, nums.length)  (,]
         * */
        private boolean nextPermutationCore(int[] nums, int curIdx){
            if(curIdx>=nums.length-1) //递归出口
                return false;

            if (nextPermutationCore(nums, curIdx+1)) //s[curIdx+1,len]得到了next permutation
                return true;
            else { //s[curIdx+1,len] 已经是子串的最后一个全排列(完全倒序)
                for (int i=nums.length-1;i>curIdx;i--){ //尝试将s[curIdx+1,len]从后往前遍历
                    //，找寻最小的数（首个比nums[curIdx]大的数）使其满足“与s[0, curIdx+1]的nums[curIdx]交换后让s[0, curIdx+1]的字典序变大最小值（
                    //即要让它变大，但是又尽量要让他变大的小）”
                    if (nums[curIdx]<nums[i]){ //找到满足条件的最小元素，与nums[curIdx] swap
                        swap(nums, curIdx, i);
                        Arrays.sort(nums, curIdx+1, nums.length);//将交换后的下位子串s[curIdx+1,len]排序成最小字典序子串
                        return true;
                    }
                }
                return false; //遍历结束后也找不到满足条件的一个元素， 说明s[curIdx,len]也已经是最大字典序全排列子串
                //，return false，交给上层去处理
            }
        }

        private void reverse(int[] nums){
            int front = 0, rear = nums.length-1;

            while (front < rear) {
                swap(nums, front, rear);
                front++;
                rear--;
            }
        }

        private void swap(int[] nums, int idx1, int idx2){
            int tmp = nums[idx1];
            nums[idx1] = nums[idx2];
            nums[idx2] = tmp;
        }

    } //inner class Solution0

}
