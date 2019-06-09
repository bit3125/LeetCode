/**�㷨������WA, Tn = O(nlogn) Sn = On
 * ����˼��ʹ��̰�ĵ�˼�루���֤�������У�����˼�����̺ܲ���
 * ���»�ԭ˼���Ĺ��̣�
 * ʹ�������α�front rear ���ֱ��ʼ��Ϊ0 heights.length
 * Ȼ�󲻶ϵ����м��ƶ��� ÿ��������С���Ǹ���
 * ��Ϊ�ں�����̵Ĺ����У�ֻ�������ݱ߳��ſ���ʹ������
 * ��ÿ�ε����α�״̬�£���Ҫ�õ���ǰ��Χ�����ӵ���͸߶ȣ����������ǰ�α귶Χ�ڳ����ε�������
 * ���ʹ�ñ����ķ�ʽ�õ���͸߶ȵĻ�����ô�ܸ��Ӷȱ���������O(n^2)�뱩�����ĸ��Ӷ�����
 * �ʿ����Ż����õ���ǰ��Χ����͸߶ȡ����㷨
 *
 * ����ÿ�˶�Ҫ����ȫ��Χ�Ƚϣ����������ϴεıȽϽ�������뵽ʹ�ö�����
 * �������ڻ����Ĺ����У�ĳ�����ӵ��˷�Χ֮�⣬��ʱ����Ҫ�ڶ��жԸ����ӽ���ɾ����
 * �������Ҫ�ڶ��в��ҵ�������ӵĻ��ֵû���On�ĸ��Ӷȣ����ܸ��ӶȽ��˻���O(n*logn*n)�ǳ�����
 * �ʿ�����취��O1��ʱ���ڵõ���ɾ������
 *
 * �뵽����һ��boolean��������е����ӽ��д洢����ʾ�������Ƿ��Ѿ����ڣ�Ȼ��ÿ�ֶ���heap��whileѭ����������ֱ��peek���ǹ�������Ϊֹ
 * �ٶԴ˷������Ż���ʡȥboolean����Ŀ�����ʹ��һ��idx-data pair��offer��heap��Ȼ�����idx�ķ�Χ��front rear�Ƚ���ȷ���Ƿ���ڣ�
 * �������⿪��On�ĸ����ռ���
 *
 * ��Ȼ���㷨�ĺ���-̰���㷨���֤���Ǵ���ģ���������˼������ֵ�ÿ϶���
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
