package leetcode.solutions;

import java.util.Arrays;

/**算法分析：Tn = On, Sn = O1
 * 本法的主体思路与Solution2一样，也是 QuickSelect+3partition，但是3partition不再使用virtual index技术（想要避免这个技巧）
 *
 * 利用3partition思想，三个游标：上层oddIdx从左往右，下层evenIdx从右往左，midIdx从上层开始到下层
 * oddIdx那块存放大数，oddIdx到midIdx存放中位数，midIdx到最后存放小数
 * oddIdx只会存在于上层，evenIdx只会在下层，而midIdx会从上层跨到下层，
 * 因为oddIdx跟evenIdx一定不会溢出，故不用管这两个游标
 *
 * 这种方法，边界条件还是有点多的。。。当场写不容易bugfree，最好老老实实用virtual index的方法(Solution2)
 * */
public class Q324WiggleSortII_Solution3 {

    public void wiggleSort(int[] nums) {
        if (nums==null || nums.length<=1) //***bug：nums.length==1的时候会出现数组越界
            return ;

        int median = nums[findMedian(nums)];
        int oddIdx = 1, evenIdx = (nums.length-1)&(-2) /*取最后一个偶数idx*/, midIdx = oddIdx;

        while ( (midIdx&1)==1 || midIdx<=evenIdx) { //midIdx还在上层的时候 || midIdx到下层了却还没超过evenIdx的时候
            if (nums[midIdx] > median) {//放到上层
                swap(nums, midIdx, oddIdx);
                oddIdx += 2;
                midIdx += 2; //必须要，因为oddIdx交换过来的都是已经是中段部分的，如果不+会死循环
            } else if (nums[midIdx] < median) {//放到下层
                swap(nums, midIdx, evenIdx);
                evenIdx -= 2;
            } else {
                midIdx += 2;
            }

            if ( (midIdx&1)==1 && midIdx>= nums.length) //***bug:没考虑到在下层越界时的情况
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
