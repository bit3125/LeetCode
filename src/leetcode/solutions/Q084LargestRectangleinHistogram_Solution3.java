/** TODO ����δ��
 * stack��ͷ�ķ���ĸ߶�һֱ����һ���ǵݼ�����(Ҳ���ǣ�
 * ���������ˣ��ö�߽������벻���ף�������Ҫ�Ǳ�0����Ĵ���ס��
 * �ȽϺõĲο����ӣ�https://www.cnblogs.com/boring09/p/4231906.html
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
        realHeights[realHeights.length-1] = 0; //��β����0�����trick�����˱߽����
        heights = realHeights;

        int curArea, maxArea = 0; //����Ƚϵ�ֵ���ǷǸ���������0��ʼ������
        int[] curRect, prevRect;
        Stack<int[]> stack = new Stack<>(); //{width, height}
        stack.push(new int[]{1, heights[0]});
        for (int i = 1; i < heights.length; i++) {
            while (!stack.isEmpty() && stack.peek()[1]>heights[i]){//�����ұ߽� //TODO
                curRect = stack.pop();
                curArea = curRect[0]*curRect[1];
                if (curArea>maxArea)
                    maxArea = curArea;

                if (!stack.isEmpty()) {
                    prevRect = stack.pop();
                    int[] newRect = new int[]{prevRect[0] + curRect[0], prevRect[1]};
                    stack.push(newRect);
                } else { //��ջ�ˣ���curRect�޶�Ϊ��height[i]���
                    int[] newRect = new int[]{curRect[0], heights[i]};
                    stack.push(newRect);
                }
            }//����stack�еĳ�����ȫ�Ǳȵ�ǰ����height[i]���ߵ�Ϊֹ
            stack.push(new int[]{1, heights[i]});//������ζ�Ҫpush��ȥ��ջ�ڲ���ȫ�Ƿǵݼ����У����Ƕ�ηǵݼ�����
                //ÿ��while����ֻҪ�㵽���μ��ɣ�ǰ���ѹ��ǰ��������Ϊ���ߣ��൱���ڱ����õ�
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Q084LargestRectangleinHistogram_Solution3 q = new Q084LargestRectangleinHistogram_Solution3();
        int[] heights = new int[]{2,1,2};
        System.out.println(q.largestRectangleArea(heights));;
    }
}
