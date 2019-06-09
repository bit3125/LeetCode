package round1;

import java.util.Arrays;

/**算法分析：Tn = On, Sn = O1
 * 这里使用的是 QuickSelect+3partition
 *
 * quickSelect部分与Solution1同理，然后找到中位数之后，本质上还是“分层两个方向进行填充”（参考Solution1中的分层思想）
 * ，但是这里使用了3partition的思想，先假设“从上层左侧到上层右侧再到下层左侧再到下层右侧”这么一条线索的idx是连续的，
 * 那么就可以使用3partion，把大数放在上层左段，小数放在下层右段，中位数放在上层右段和下层左段。
 * →→→
 *   O   O
 * O   O
 *    ←←←
 * 于是乎问题就转化为：如何找到一种idx的映射方式，让我们可以使用“left，mid，right”三个游标逻辑上从0到n-1进行3partition的遍历？
 * 也即，我们可使用一种映射关系，将三个游标映射到分层模型中的真实游标，使用逻辑连续游标对物理数组进行3partition操作
 * 这里就使用了 newIdx()映射函数。至于怎么推导出这种关系的，我也想不明白。。。。
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
        return (1+2*idx)%(n|1); //(n|1)作用为 把n取到最近的一个奇数(向上取)
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
