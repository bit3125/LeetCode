package leetcode.solutions;

import java.util.Arrays;
import java.util.Random;

/**�㷨������Tn=On Sn=On
 * ����ʹ����Fisher Yates�㷨���������Tn=On����������еķ���
 * ���������ص���ǣ��ܹ�ͨ��n�ε�ѡȡ��ʹ�÷�Χ��[0,n)�е����������������
 * ��һ������ʹ�õ���ȡ���nextPermutation�ķ���������permutation���������ܾ޴�
 * ����ʹ�õ������ȡֵ�����int��Χ����ʧЧ��
 *
 * ��Ŀ��without duplicates�տ�ʼ���Ϊ���ܸ�������һ�ݿ�����������ô�붼�벻��Sn=O1�İ취
 * ��������������nums��û���ظ����ֵ���˼������
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
