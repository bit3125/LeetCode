package leetcode.solutions;

/**�㷨������ Tn = On, Sn = O1
 * ���㷨��˼��ʵ���ǲ�̫����⣬�ɰ������½��ͣ�
 * ά������bound������ ��nums���б����������Ĺ����в��ϸ�������bound
 * �������Ϊ����������i��ʱ��[0, i-1]֮����������У��������ɳ���Ϊ1�ĵ��������������ɳ���Ϊ2�ĵ���������
 * ����ʹ��len1Bound������ǰ���е�rightBound��С�ߣ�ʹ��len2Bound����������е�rightBound��С��
 * Ϊ��ֻ����rightBound��С���Ǹ��������أ�����Ϊ�����������Ԫ���У����������rightBound��С���Ǹ������У���ôһ��Ҳ�����������������С�
 *
 * ��nums���б�����
 * �� nums[i] <= len1Bound��ʱ����ô����Ϊ1���������е�rightBound�Ϳ��Ը���
 * �� len1Bound < nums[i] <= len2Bound ��ʱ����ô����Ϊ2���������е�rightBound�Ϳ��Ը���(<��֤��iǰ���г���Ϊ1�ĵ���������
 * ������ƴ�ӣ���ɳ���Ϊ2�ĵ���������)
 * �� nums[i]> len2Bound ��ʱ��˵��nums[i]ǰ����ڳ���Ϊ2�ĵ��������У�������ƴ�ӣ�return true
 *
 * ���㷨����ƹ㵽 targetLen=k �������
 * */
public class Q334IncreasingTripletSubsequence_Solution2 {

    public boolean increasingTriplet(int[] nums) {
        if (nums==null || nums.length<3)
            return false;

        int len1Bound = Integer.MAX_VALUE, len2Bound = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= len1Bound) { // nums[i] <= len1Bound
                len1Bound = nums[i];
            } else if (nums[i] <= len2Bound) { // len1Bound< nums[i] <=len2Bound
                len2Bound = nums[i];
            } else { //nums[i]> len2Bound
                return true;
            }
        }

        return false;
    }

}
