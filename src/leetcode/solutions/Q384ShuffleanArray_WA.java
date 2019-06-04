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
            this.cnt += shuffleTimes; //***bug:��ȵ�0����+
            while (shuffleTimes > 0) {
                if (!nextPermutationCore(nums, 0))  //�ǵ���״̬
                    reverse(nums);
                shuffleTimes--;
            }
        }

        /**���ڵõ�idxλ��ʼ(inclusive)���Ӵ���nextȫ����
         *
         * return : �Ƿ�ɹ��õ�
         * ����s[i,len]Ϊnums.substring(i, nums.length)  (,]
         * */
        private boolean nextPermutationCore(int[] nums, int curIdx){
            if(curIdx>=nums.length-1) //�ݹ����
                return false;

            if (nextPermutationCore(nums, curIdx+1)) //s[curIdx+1,len]�õ���next permutation
                return true;
            else { //s[curIdx+1,len] �Ѿ����Ӵ������һ��ȫ����(��ȫ����)
                for (int i=nums.length-1;i>curIdx;i--){ //���Խ�s[curIdx+1,len]�Ӻ���ǰ����
                    //����Ѱ��С�������׸���nums[curIdx]�������ʹ�����㡰��s[0, curIdx+1]��nums[curIdx]��������s[0, curIdx+1]���ֵ�������Сֵ��
                    //��Ҫ������󣬵����־���Ҫ��������С����
                    if (nums[curIdx]<nums[i]){ //�ҵ�������������СԪ�أ���nums[curIdx] swap
                        swap(nums, curIdx, i);
                        Arrays.sort(nums, curIdx+1, nums.length);//�����������λ�Ӵ�s[curIdx+1,len]�������С�ֵ����Ӵ�
                        return true;
                    }
                }
                return false; //����������Ҳ�Ҳ�������������һ��Ԫ�أ� ˵��s[curIdx,len]Ҳ�Ѿ�������ֵ���ȫ�����Ӵ�
                //��return false�������ϲ�ȥ����
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
