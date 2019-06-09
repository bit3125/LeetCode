package round1;

import java.util.Arrays;

/**�㷨������Tn = On, Sn = O1
 * ����ʹ�õ��� QuickSelect+3partition
 *
 * quickSelect������Solution1ͬ��Ȼ���ҵ���λ��֮�󣬱����ϻ��ǡ��ֲ��������������䡱���ο�Solution1�еķֲ�˼�룩
 * ����������ʹ����3partition��˼�룬�ȼ��衰���ϲ���ൽ�ϲ��Ҳ��ٵ��²�����ٵ��²��Ҳࡱ��ôһ��������idx�������ģ�
 * ��ô�Ϳ���ʹ��3partion���Ѵ��������ϲ���Σ�С�������²��ҶΣ���λ�������ϲ��Ҷκ��²���Ρ�
 * ������
 *   O   O
 * O   O
 *    ������
 * ���Ǻ������ת��Ϊ������ҵ�һ��idx��ӳ�䷽ʽ�������ǿ���ʹ�á�left��mid��right�������α��߼��ϴ�0��n-1����3partition�ı�����
 * Ҳ�������ǿ�ʹ��һ��ӳ���ϵ���������α�ӳ�䵽�ֲ�ģ���е���ʵ�α꣬ʹ���߼������α�������������3partition����
 * �����ʹ���� newIdx()ӳ�亯����������ô�Ƶ������ֹ�ϵ�ģ���Ҳ�벻���ס�������
 *
 * */
public class Q324WiggleSortII_Solution2 {

    public void wiggleSort(int[] nums) {
        if (nums==null || nums.length==0)
            return ;

        int n = nums.length;
        int median = nums[findMedian(nums)];
        int left = 0, mid = 0, right = n-1;
        int newL, newM, newR ;
        while (mid <= right) {
            newL = newIdx(n, left);
            newM = newIdx(n, mid);
            newR = newIdx(n, right);
            if (nums[newM]>median) {
                swap(nums, newM, newL);
                left++;
                mid++;
            } else if (nums[newM] < median) {
                swap(nums, newM, newR);
                right--;
            } else {
                mid++;
            }
        }

    }

    private int newIdx(int n, int idx) {
        return (1+2*idx)%(n|1); //(n|1)����Ϊ ��nȡ�������һ������(����ȡ)
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
        int[] nums = new int[]{1, 3, 2, 2, 3, 1};
        Q324WiggleSortII_Solution2 q = new Q324WiggleSortII_Solution2();
        q.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));

    }

}
