package leetcode.solutions;

import java.util.Arrays;

/**算法分析：Tn = On, Sn = On
 *
 * 先找到中位数（这里使用快速选择算法，On）
 * 然后从左往右奇数索引位置放大于中位数的数, 然后从右往左在偶数索引位置放小于中位数的数, 剩下的位置都放中位数
 * 注意：在找到中位数之后有两种填充方法：
 * 1.“偶数位从左往右，奇数位从右往左，剩下用中位数填充”，X
 * 2.“偶数位从右往左，奇数位从左往右，剩下用中位数填充”，√
 * 为什么1不行呢？可以这么理解：使用4位的情况来理解，
 * 我们本质就是在上下层中分别选择一端来存放中位数，那么想让中位数尽可能地不碰撞在一起，所以上下层一个选左端一个选右端。
 * →→→
 *   O   O
 * O   O
 *    ←←←
 * 上下两层的中位数填充端，在2.方式下比1.方式下相距更远，更不容易发生碰撞，故应当选择方式2.（本质是因为题目规定的排序后数组
 * 的波浪形并非对称的，而一定起手是上升的）
 *
 * */
public class Q324WiggleSortII_Solution1 {

    public void wiggleSort(int[] nums) {
        if (nums==null || nums.length==0)
            return ;

        int medianIdx = findMedian(nums);
        int[] copy = Arrays.copyOf(nums, nums.length);
        int evenIdx = (nums.length&1)==0?nums.length-2:nums.length-1/*取最后一个偶数idx*/,
                oddIdx = 1, copyIdx;

        copyIdx = 0;
        while (copyIdx < medianIdx /*&& evenIdx<nums.length*/) {
            if (copy [copyIdx] != copy[medianIdx]) {
                nums[evenIdx] = copy[copyIdx];
                evenIdx -= 2;
            }
            copyIdx++;
        }
        copyIdx = medianIdx+1;
        while (copyIdx < nums.length /* oddIdx>=0*/) {
            if (copy[copyIdx] != copy[medianIdx]) {
                nums[oddIdx] = copy[copyIdx];
                oddIdx += 2;
            }
            copyIdx++;
        }

        while (evenIdx>=0) {
            nums[evenIdx] = copy[medianIdx];
            evenIdx -= 2;
        }
        while (oddIdx<nums.length) {
            nums[oddIdx] = copy[medianIdx];
            oddIdx += 2;
        }
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
        Q324WiggleSortII_Solution1 q = new Q324WiggleSortII_Solution1();
        q.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));

    }

}
