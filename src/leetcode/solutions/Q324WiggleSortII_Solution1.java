package leetcode.solutions;

import java.util.Arrays;

/**�㷨������Tn = On, Sn = On
 *
 * ���ҵ���λ��������ʹ�ÿ���ѡ���㷨��On��
 * Ȼ�����������������λ�÷Ŵ�����λ������, Ȼ�����������ż������λ�÷�С����λ������, ʣ�µ�λ�ö�����λ��
 * ע�⣺���ҵ���λ��֮����������䷽����
 * 1.��ż��λ�������ң�����λ��������ʣ������λ����䡱��X
 * 2.��ż��λ������������λ�������ң�ʣ������λ����䡱����
 * Ϊʲô1�����أ�������ô��⣺ʹ��4λ���������⣬
 * ���Ǳ��ʾ��������²��зֱ�ѡ��һ���������λ������ô������λ�������ܵز���ײ��һ���������²�һ��ѡ���һ��ѡ�Ҷˡ�
 * ������
 *   O   O
 * O   O
 *    ������
 * �����������λ�����ˣ���2.��ʽ�±�1.��ʽ������Զ���������׷�����ײ����Ӧ��ѡ��ʽ2.����������Ϊ��Ŀ�涨�����������
 * �Ĳ����β��ǶԳƵģ���һ�������������ģ�
 *
 * */
public class Q324WiggleSortII_Solution1 {

    public void wiggleSort(int[] nums) {
        if (nums==null || nums.length==0)
            return ;

        int medianIdx = findMedian(nums);
        int[] copy = Arrays.copyOf(nums, nums.length);
        int evenIdx = (nums.length&1)==0?nums.length-2:nums.length-1/*ȡ���һ��ż��idx*/,
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
