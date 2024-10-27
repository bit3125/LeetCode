package round4.q152;

import java.util.Arrays;

/**
 * �������Ƕ�̬�滮
 * ״̬���壺
 * dp_prev_max[i]Ϊ�� nums[i]��β��������������˻�����
 * dp_prev_min[i]Ϊ�� nums[i]��β��������������˻�����
 * dp_prev_max[i]ֻ�����ܴ�������ѡ����ȡ�ã�dp_prev_max[i-i] * nums[i], dp_prev_min[i-1] * nums[i], nums[i]
 *
 * ״̬ת�Ʒ���α���룺
 * for i
 *  a = dp_prev_max[i-i] * nums[i]
 *  b = dp_prev_min[i-1] * nums[i]
 *  c = nums[i]
 *  dp_prev_max[i] = max(a, b, c)
 *  dp_prev_min[i] = min(a, b, c)
 *
 * result = max(dp_prev_max)
 *
 * ����״̬ת��ֻ��ǰ���йأ� dp����ɱ��Ż�Ϊ������
 * */

class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int maxPrevProd = nums[0] /*dp1*/, minPrevProd = nums[0] /*dp2*/, maxProd = nums[0];
        int[] candidates = new int[3];
        for (int i = 1; i < nums.length; i++) {
            candidates[0] = maxPrevProd * nums[i];
            candidates[1] = minPrevProd * nums[i];
            candidates[2] = nums[i];

            Arrays.sort(candidates);
            maxPrevProd = candidates[2];
            minPrevProd = candidates[0];
            maxProd = Integer.max(maxProd, maxPrevProd);
        }

        return maxProd;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, -2, 4};
        Solution sl = new Solution();
        System.out.println(sl.maxProduct(nums));
    }
}