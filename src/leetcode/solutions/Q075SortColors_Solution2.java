/**�㷨�����������˻��������Ϊ��ż���е�ͷβ˫ָ�뷨������㷨�Ǹ�partition���Ƶģ�ע��Ƚ�
 * ʹ������ָ�룬�������Ϊ��0����1����0���������У�front, mid, rear��
 * �������еķ�Χ�ֱ�Ϊ [0,front), [front,mid), (rear, nums.length)�� Ȼ��[mid, rear]��Ϊδ��������
 * ���㷨�Ĺؼ�һ���ǣ�ʹ�á�swap�������ǡ�overwrite������Ҳ����partition����������
 * 1.partition�㷨�У�������ǰ��nums[0]���뵽��pivot�����д洢����������nums�ж���һ����λ��������
 * 	�׻�βָ�����о�ֹ���Ǹ�ָ��ľ��ǿ�λ��ÿ��������"overwrite"����"swap"
 * 2.������ż���е��㷨�У�û�б���ȥ�ݴ�ĳ�������������������ģ���ÿ��������"swap"����"overwrite"�������㷨ͬ��
 * 
 * ��ÿ��ѭ���У���swap��ʱ���Ϊ���������
 * 1.nums[mid]==0 rear��mid swap
 * 	ֱ��swap���ɣ�mid�߽粻�䣬rear�߽�--
 * 2.nums[mid]==2 front��mid swap
 * ����front��mid�����λ�ò�ȷ������Ҫ��Ϊ����������ۣ���ͼ�������ͱȽ�������
 * 	1>.front=k, mid>=k+2.[0,front)Ϊ0����, [front,mid)Ϊ1���У��ʽ�����mid�ϵ���1����front++ mid++
 * 	2>.front=k, mid=k+1. ����ָ�밤��һ�𡣻�ͼ��֪��1>.�����ͬ
 * 	3>.front=k, mid=k. ����ָ���غ���ȡ���ͼ��֪��ʱ1���г���Ϊ0����front++ midҲ��++
 * ����������2.����������£�ָ��仯����front++ mid++
 * 3.nums[mid]==1 ������swap
 * 1����������mid++
 * 
 * */

package leetcode.solutions;

import java.util.Arrays;

public class Q075SortColors_Solution2 {
	
	public void sortColors(int[] nums) {
        if (nums==null||nums.length==0)
        	return;
        
        int front = 0, rear = nums.length-1, mid = front;
        while(mid<=rear){
        	if (nums[mid]==0){
        		swap(nums, front++, mid++);
        	}else if (nums[mid]==2){
    			swap(nums, rear--, mid);
    		}else{
    			mid++;
    		}
        }
        
    }
	
	public void swap(int[] nums, int idx1, int idx2){
		int tmp = nums[idx1];
		nums[idx1] = nums[idx2];
		nums[idx2] = tmp;
	}
	
	public static void main(String[] args) {
		Q075SortColors_Solution2 q = new Q075SortColors_Solution2();
		int[] nums = new int[]{1,0};
		q.sortColors(nums);
		
		System.out.println(Arrays.toString(nums));
		
	}

}
