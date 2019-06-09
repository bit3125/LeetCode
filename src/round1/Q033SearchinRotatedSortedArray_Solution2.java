/**�㷨������ֱ����ԭ�����Ͻ��ж�������
 * ʹ��front mid rear���ֺ󣬸�������һ���ص㣺[front,mid] [mid, rear]��������һ��Ϊ����
 * �������������
 * 1.���ҽ���һ����������
 * 2.���߶�������Ҳ����ʱ[front, rear]�����Ѿ���һ����ͨ��������
 * ���������������е��������ж�������Χ����ѹ��
 * ������·�����
 * 
 * */

package round1;

public class Q033SearchinRotatedSortedArray_Solution2 {

	public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){//���͵Ķ�������while�ж�����
            int mid = (start + end) / 2;
            
            if (nums[mid] == target)
                return mid;
            
            //else
            if (nums[start] <= nums[mid]){ //ǰ�������
                 if (target < nums[mid] && target >= nums[start])//target�ڴ˶���
                    end = mid - 1;//��endѹ��mid-1��
                 else//target����һ����
                    start = mid + 1;//��startѹ��mid+1��
                 
                 //��[front, rear]��Ϊһ����ͨ�������У�
                 //��ôÿ��while���˻�Ϊֻ��ִ���Ϸ������д��룬�·���else��ʧЧ��
            }else{ //(nums[mid] <= nums[end]) //��������
                if (target > nums[mid] && target <= nums[end])//target�ڴ˶���
                    start = mid + 1;
                 else
                    end = mid - 1;
            }
        }
        return -1;
    }
	
	
	public static void main(String[] args) {
		Q033SearchinRotatedSortedArray_Solution2 q = new Q033SearchinRotatedSortedArray_Solution2();
//		int[] nums = {1,3};
//		int target = 1;
		int[] nums = {3,5,1};
		int target = 5;
		
		
		System.out.println(q.search(nums, target));
		
	}

}
