/**算法分析：Tn = O(n*?)
 * 如果我们能得到两个状态数组，分别表示柱子i中左边第一个比它小的柱子idx，以及右边&*……&*，那么就可以根据这两个值计算出包含柱子i在内的最大长方形面积
 * 故关键为题转化为如何得到这两个状态数组
 * 这里使用类动规的方法
 * ，先判断当前柱子左侧的柱子j是否是第一个比当前柱子小的柱子，
 * 若是则得到所求，若否则迭代判断leftBounds[j],就这样一直向左侧搜索，
 * 因为若heights[j]>heights[i] 则i到j之间所有的柱子都比i要高，故可以一直向左侧搜索
 *
 * 这样一趟搜索的复杂度，最坏情况下是O(n)，但是实际情况会好很多
 * 故此算法的最坏情况是Tn = O(n^2)，但是实际的时间开销似乎接近于O(n)
 *
 * */

package round1;

public class Q084LargestRectangleinHistogram_Solution2 {

    public int largestRectangleArea(int[] heights) {
        if (heights==null || heights.length==0)
            return 0;

        int[] leftBounds = new int[heights.length]; //exclusive 左侧第一个比当前柱子小的柱子的idx
        int[] rightBounds = new int[heights.length]; //exclusive 右侧第一个比当前柱子小的柱子的idx
        //preparation
        for (int i = 0; i < heights.length; i++) {
            int j = i-1;
            while (j>=0 && heights[j] >= heights[i])
                j = leftBounds[j];
            leftBounds[i] = j;
        }
        for (int i = heights.length-1; i >= 0; i--) {
            int j = i+1;
            while (j<=heights.length-1 && heights[j] >= heights[i])
                j = rightBounds[j];
            rightBounds[i] = j;
        }

        //cal
        int curArea, maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            curArea = (rightBounds[i]-leftBounds[i]-1)*heights[i];
            if (curArea>maxArea)
                maxArea = curArea;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Q084LargestRectangleinHistogram_Solution2 q = new Q084LargestRectangleinHistogram_Solution2();
        int[] heights = new int[]{2,1,5,6,2,3};
        System.out.println(q.largestRectangleArea(heights));
    }
}
