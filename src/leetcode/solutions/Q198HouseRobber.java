/**�㷨������1d DP , 
 * ״̬���壺f[i] Ϊ 0~i�䷿���ܵõ�����߼�ֵ
 * ״̬ת�Ʒ��̣�f[i] = max{f[i-1], f[i-2]+nums[i]}
 * ��ʼ������f[0] = nums[0] , f[1] = max{nums[0], nums[1]}
 * 
 * f[i] ������ת����Դ��1.͵house[i]ʱ�� ����͵house[i-1]���� ��Դ��f[i-2](ǰ��ķ���͵��͵����ν��ֻҪhouse[i-1]��͵�ͺ�)��
 * 					2.��͵house[i]ʱ������Դ��f[i-1](������͵house[i]������ν͵��͵house[i-1])
 * 
 * */


package leetcode.solutions;

public class Q198HouseRobber {

	public int rob(int[] nums) {
		if (nums==null || nums.length==0)
			return 0;
		if (nums.length==1)
			return nums[0];
		
		//else: nums.length>=2
		//init
		int[] f = new int[nums.length];
		f[0] = nums[0];
		f[1] = Integer.max(nums[1], nums[0]);
		
		for (int i=2;i<nums.length;i++){
			f[i] = Integer.max(f[i-1], f[i-2]+nums[i]);
		}
		
		return f[f.length-1];
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
