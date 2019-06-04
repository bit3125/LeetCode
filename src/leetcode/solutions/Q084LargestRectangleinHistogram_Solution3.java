/** TODO 悬而未决
 * stack里头的方块的高度一直保持一个非递减序列(也不是）
 * 先溜了溜了，好多边界条件想不明白，这里主要是被0方块的处理卡住了
 * 比较好的参考链接：https://www.cnblogs.com/boring09/p/4231906.html
 * */

package leetcode.solutions;

import java.util.Arrays;
import java.util.Stack;

public class Q084LargestRectangleinHistogram_Solution3 {

    public int largestRectangleArea(int[] heights) {
        if (heights==null || heights.length==0)
            return 0;

        int[] realHeights = new int[heights.length+1];
        System.arraycopy(heights, 0, realHeights, 0, heights.length);
        realHeights[realHeights.length-1] = 0; //首尾插入0方块的trick大大简化了边界操作
        heights = realHeights;

        int curArea, maxArea = 0; //后面比较的值都是非负数，故用0初始化即可
        int[] curRect, prevRect;
        Stack<int[]> stack = new Stack<>(); //{width, height}
        stack.push(new int[]{1, heights[0]});
        for (int i = 1; i < heights.length; i++) {
            while (!stack.isEmpty() && stack.peek()[1]>heights[i]){//遇到右边界 //TODO
                curRect = stack.pop();
                curArea = curRect[0]*curRect[1];
                if (curArea>maxArea)
                    maxArea = curArea;

                if (!stack.isEmpty()) {
                    prevRect = stack.pop();
                    int[] newRect = new int[]{prevRect[0] + curRect[0], prevRect[1]};
                    stack.push(newRect);
                } else { //空栈了，将curRect修短为与height[i]齐高
                    int[] newRect = new int[]{curRect[0], heights[i]};
                    stack.push(newRect);
                }
            }//处理到stack中的长方形全是比当前长条height[i]不高的为止
            stack.push(new int[]{1, heights[i]});//无论如何都要push进去，栈内并非全是非递减序列，而是多段非递减序列
                //每次while计算只要算到本段即可，前面段压在前面用来作为界线（相当于哨兵）用的
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Q084LargestRectangleinHistogram_Solution3 q = new Q084LargestRectangleinHistogram_Solution3();
        int[] heights = new int[]{2,1,2};
        System.out.println(q.largestRectangleArea(heights));;
    }
}
