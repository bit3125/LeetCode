/**算法分析：WA, Tn = O(nlogn) Sn = On
 * 基本思想使用贪心的思想（最后证明不可行，但是思考过程很不错）
 * 以下还原思考的过程：
 * 使用两个游标front rear ，分别初始化为0 heights.length
 * 然后不断的向中间移动， 每次舍弃较小的那个边
 * 因为在横边缩短的过程中，只有增加纵边长才可能使面积变大。
 * 在每次的新游标状态下，需要得到当前范围内柱子的最低高度，就能求出当前游标范围内长方形的最大面积
 * 如果使用遍历的方式得到最低高度的话，那么总复杂度便提升到了O(n^2)与暴力法的复杂度无异
 * 故考虑优化“得到当前范围内最低高度”的算法
 *
 * 由于每趟都要重新全范围比较，考虑利用上次的比较结果，故想到使用堆排序
 * 但当窗口滑动的过程中，某个柱子到了范围之外，这时候需要在堆中对该柱子进行删除，
 * 但是如果要在堆中查找到这个柱子的话又得花费On的复杂度，则总复杂度将退化成O(n*logn*n)非常可怕
 * 故考虑想办法在O1的时间内得到待删的柱子
 *
 * 想到开辟一个boolean数组对所有的柱子进行存储，表示柱子们是否已经过期，然后每轮都对heap用while循环进行清理直到peek不是过期柱子为止
 * 再对此法进行优化：省去boolean数组的开销，使用一个idx-data pair来offer给heap，然后根据idx的范围与front rear比较来确定是否过期，
 * 不用另外开辟On的辅助空间了
 *
 * 虽然此算法的核心-贪心算法最后被证明是错误的，但是整个思考过程值得肯定！
 *
 * */

package round1;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q084LargestRectangleinHistogram_Solution1 {

    public int largestRectangleArea(int[] heights) {
        if (heights==null || heights.length==0)
            return 0;

        //init
        int maxArea = Integer.MIN_VALUE;
        int front = 0, rear = heights.length-1; //inclusive, inclusive
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        for (int i = 0; i < heights.length; i++)
            q.offer(new int[]{i, heights[i]});

        //cal
        int curArea;
        while (front <= rear) {
            //clear
            while (q.peek()[0] < front || q.peek()[0] > rear)
                q.poll();

            curArea = q.peek()[1]*(rear-front+1);
            if (curArea > maxArea)
                maxArea = curArea;

            //step forward
            if (heights[front] < heights[rear]) {
                front++;
            } else
                rear--;
        }

        return maxArea;
    }

}
