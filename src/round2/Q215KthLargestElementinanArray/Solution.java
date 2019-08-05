package round2.Q215KthLargestElementinanArray;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums==null || nums.length==0)
            return -1;

        int targetIdx = nums.length - k;
        int front = 0, rear = nums.length - 1, mid;
        while (front <= rear) {
            mid = partition(nums, front, rear + 1);
            if (mid == targetIdx) {
                return nums[mid];
            } else if (mid < targetIdx) {
                front = mid + 1;
            } else { // >
                rear = mid - 1;
            }
        }
        return -1; // can't arrive
    }

    private int partition(int[] nums, int start, int end) {
        if ( start >= end) // length <= 0, illegal
            return -1;

        int pivot = nums[start];
        int front = start, rear = end - 1;
        while (front < rear) { // redundant
            while (front < rear && nums[rear] >= pivot) //***bug: && nums[rear] > pivot. ���˴��Բ�ȡ�ȣ���ô��Ϊ==����Ҳ����swap����ô��front��rearͬʱ����==��ʱ�������������Բ��۳���Ч�ʻ��ǿ����Կ���==�Ķ���Ӧ�ý���
                rear--;
            if (front >= rear)
                break;
            nums[front] = nums[rear];

            while (front < rear && nums[front] <= pivot)
                front++;
            if (front >= rear)
                break;
            nums[rear] = nums[front];
        }
        // after above, front==rear
        nums[front] = pivot;
        return front;
    }
}