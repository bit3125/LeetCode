/**�㷨������Tn = O(n*?)
 * ��������ܵõ�����״̬���飬�ֱ��ʾ����i����ߵ�һ������С������idx���Լ��ұ�&*����&*����ô�Ϳ��Ը���������ֵ�������������i���ڵ���󳤷������
 * �ʹؼ�Ϊ��ת��Ϊ��εõ�������״̬����
 * ����ʹ���ද��ķ���
 * �����жϵ�ǰ������������j�Ƿ��ǵ�һ���ȵ�ǰ����С�����ӣ�
 * ������õ���������������ж�leftBounds[j],������һֱ�����������
 * ��Ϊ��heights[j]>heights[i] ��i��j֮�����е����Ӷ���iҪ�ߣ��ʿ���һֱ���������
 *
 * ����һ�������ĸ��Ӷȣ���������O(n)������ʵ�������úܶ�
 * �ʴ��㷨��������Tn = O(n^2)������ʵ�ʵ�ʱ�俪���ƺ��ӽ���O(n)
 *
 * */

package round1;

public class Q084LargestRectangleinHistogram_Solution2 {

    public int largestRectangleArea(int[] heights) {
        if (heights==null || heights.length==0)
            return 0;

        int[] leftBounds = new int[heights.length]; //exclusive ����һ���ȵ�ǰ����С�����ӵ�idx
        int[] rightBounds = new int[heights.length]; //exclusive �Ҳ��һ���ȵ�ǰ����С�����ӵ�idx
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
