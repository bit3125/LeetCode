/**�㷨������r1����Ϊ̰���㷨��������Ϊ�Ǽ�֦��Ķ�̬�滮
 * ������ٹ���n^2����ϡ��ֿ��ǽ����Ӷ��Ż�������
 * �������α��ʼ������β
 * Area���������ؾ�����1.Integer.min(height[left], height[right]) ��2.dist = right - left
 * �������α����ڲ�����ʱ��dist�ڼ�С����ֻ�ж̱߱䳤���п�����Area����
 * ��Ӧ���ö̱����ƽ���������
 * �ڶ̱����ƹ����У����߹̶�����������������̱����ƵĲ������ֱ�ӱ���֦���ˣ�������Ϊ���ԭ�������֦
 *
 * ʹ��һ��whileѭ��������������ÿ�ζ����ƶ̱ߣ����������Եĸ��Ӷȵõ����Ž�
 *
 * */

package round2.Q011ContainerWithMostWater;

class Solution {
    public int maxArea(int[] height) {
        if (height==null || height.length==0)
            return 0;

        int left = 0, right = height.length-1;
        int curArea, maxArea = Integer.min(height[left], height[right]) * (right - left);

        while (left<right) {
            if (height[left] < height[right])
                left++;
            else
                right--;
            curArea = Integer.min(height[left], height[right]) * (right - left);
            maxArea = Integer.max(curArea, maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,4,5,18,17,6};
        Solution sl = new Solution();
        System.out.println(sl.maxArea(nums));;
    }
}