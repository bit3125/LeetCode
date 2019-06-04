package leetcode.solutions;

import java.util.Arrays;

/**�㷨������Tn = On, Sn = O1
 * ����������˼·��Solution2һ����Ҳ�� QuickSelect+3partition������3partition����ʹ��virtual index��������Ҫ����������ɣ�
 *
 * ����3partition˼�룬�����α꣺�ϲ�oddIdx�������ң��²�evenIdx��������midIdx���ϲ㿪ʼ���²�
 * oddIdx�ǿ��Ŵ�����oddIdx��midIdx�����λ����midIdx�������С��
 * oddIdxֻ��������ϲ㣬evenIdxֻ�����²㣬��midIdx����ϲ�絽�²㣬
 * ��ΪoddIdx��evenIdxһ������������ʲ��ù��������α�
 *
 * ���ַ������߽����������е��ġ���������д������bugfree���������ʵʵ��virtual index�ķ���(Solution2)
 * */
public class Q324WiggleSortII_Solution3 {

    public void wiggleSort(int[] nums) {
        if (nums==null || nums.length<=1) //***bug��nums.length==1��ʱ����������Խ��
            return ;

        int median = nums[findMedian(nums)];
        int oddIdx = 1, evenIdx = (nums.length-1)&(-2) /*ȡ���һ��ż��idx*/, midIdx = oddIdx;

        while ( (midIdx&1)==1 || midIdx<=evenIdx) { //midIdx�����ϲ��ʱ�� || midIdx���²���ȴ��û����evenIdx��ʱ��
            if (nums[midIdx] > median) {//�ŵ��ϲ�
                swap(nums, midIdx, oddIdx);
                oddIdx += 2;
                midIdx += 2; //����Ҫ����ΪoddIdx���������Ķ����Ѿ����жβ��ֵģ������+����ѭ��
            } else if (nums[midIdx] < median) {//�ŵ��²�
                swap(nums, midIdx, evenIdx);
                evenIdx -= 2;
            } else {
                midIdx += 2;
            }

            if ( (midIdx&1)==1 && midIdx>= nums.length) //***bug:û���ǵ����²�Խ��ʱ�����
                midIdx = 0;
        }

        while (oddIdx < nums.length) {
            nums[oddIdx] = median;
            oddIdx += 2;
        }
        while (evenIdx >= 0) {
            nums[evenIdx] = median;
            evenIdx -= 2;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int findMedian(int[] nums) {
        int medianIdx = (nums.length - 1) / 2;
        int pivotIdx = -1;
        int front = 0, rear = nums.length-1;
        while (front<=rear) { //binary search
            pivotIdx = partition(nums, front, rear+1);
            if (pivotIdx < medianIdx) {
                front = pivotIdx + 1;
            } else if (pivotIdx > medianIdx) {
                rear = pivotIdx - 1;
            } else {
                break;
            }
        }

        return medianIdx;
    }

    public int partition(int[] nums, int start, int end) {
        if (start>=end)
            return -1;

        int front = start, rear= end-1;
        int pivot = nums[start];
        while (front < rear) {
            while(front<rear && nums[rear]>=pivot)
                rear--;
            nums[front] = nums[rear];
            while(front<rear && nums[front]<=pivot)
                front++;
            nums[rear] = nums[front];
        }
        nums[front] = pivot;
        return front;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1,5,1,1,6,4};
        int[] nums = new int[]{4,5,5,6};
        Q324WiggleSortII_Solution3 q = new Q324WiggleSortII_Solution3();
        q.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));

    }

}
