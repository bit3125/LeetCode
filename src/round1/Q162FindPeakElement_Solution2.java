/**�㷨������ Tn = Ologn
 *
 * ʹ��Binary Search��while����front<=rear,
 * bs�ı�����Ȧ��һ����Χ��Ȼ�󲻶ϸ���mid���ж���������һ����������Χ��С���϶����ҵ�target���·�Χ��
 *
 * ��front��rear�ֱ�ָ������ҵ�target�����е���߽����ұ߽� [inclusive, inclusive]��
 * �ʴ�ʱwhile�����Ϳ�����Ϊfront<rear����Ϊ��front��rear�������ڶ��Ѹ���
 * ����ҪѰ�ҵ�peek��ʵ����local max����������������
 * 1. 0 == mid || nums[mid - 1] < nums[mid] ���������
 * 2. nums.length - 1 == mid || nums[mid] > nums[mid + 1]�� �Ҳ�����
 * ��������if��֧�������������ж�
 * 1. �������������������mid�ض�����target����[0,mid-1]�бض�������������target����Ϊ�����Ҷ˵㵼��Ϊ������˵�->-�ޣ�
 * �ʿɽ�������Χ��С��[0, mid-1]
 * 2. ���������Ҳ���������mid�ض�����target����[mid+1, nums.length-1]�бض�������������target����Ϊ������˵㵼��Ϊ�����Ҷ˵�->-�ޣ�
 * �ʿɽ�������Χ��С��[mid+1, nums.length-1]
 * �Դ�����ֱ���ҵ�target
 *
 * */
package round1;

public class Q162FindPeakElement_Solution2 {
    public int findPeakElement(int[] nums) {
        if (nums==null||nums.length==0)
            return -1;

        int front = 0, rear = nums.length - 1;
        int mid;
        while (front <= rear) {
            mid = (front + rear) / 2;
            if (!(0 == mid || nums[mid - 1] < nums[mid])) {//mid��಻����
                rear = mid-1;
            } else if (!(nums.length - 1 == mid || nums[mid] > nums[mid + 1])) { //mid�Ҳ಻����
                front = mid+1;
            } else  //���Ҳ������
                return mid;
        }
        return -1;
    }

}
