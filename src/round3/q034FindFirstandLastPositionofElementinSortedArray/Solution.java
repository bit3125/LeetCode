package round3.q034FindFirstandLastPositionofElementinSortedArray;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        int front, rear, mid;

        // find left
        // ��front��Զָ�� < target�Ĳ���
        // ��rear��Զָ�� >= target�Ĳ���
        if (nums[0] == target) {
            //***BUG: �߽��ж�. ��idx0 == target��ʱ��, front�ĳ�ʼֵ�޷����㶨��, �ʺ���������������
            // Ҫ����������߽紦��.
            result[0] = 0;
        } else {
            front = 0;
            rear = nums.length - 1;
            while (rear - front > 1) {
                mid = (front + rear) / 2;
                if (target <= nums[mid]) {
                    rear = mid;
                } else { // target > nums[mid]
                    front = mid;
                }
            }
            if (nums[rear] != target) {
                return result;
            }
            result[0] = rear;
        }

        // find right
        if (nums[nums.length - 1] == target) {
            //***BUG: ͬ��
            result[1] = nums.length - 1;
        } else {
            front = 0;
            rear = nums.length - 1;
            while (rear - front > 1) {
                mid = (front + rear) / 2;
                if (target < nums[mid]) {
                    rear = mid;
                } else { // target >= nums[mid]
                    front = mid;
                }
            }
            result[1] = front;
        }

        return result;
    }
}