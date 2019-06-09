/**�㷨����������DP���㷨��Tn = On�� Sn = On
 * ÿ��bin�ܹ��洢��ˮ����ȡ��������lowestBound[i] = Integer.max(leftHighestBar[i], rightHighestBar[i])��������lowestBound��
 * ��������ˮ��Ϊheight[i]-lowestBound[i]
 *
 * ��������DP���飺leftHighest rightHighest���ֱ����
 * Ȼ���ٽ���һ�α����������ÿ��bin����ˮ�����ۼ�
 *
 * ����Tn=On, Sn=O1���㷨�������о�
 * */


package round1;

public class Q042TrappingRainWater {

    public int trap(int[] height) {
        if (height==null || height.length==0)
            return 0;

        //init
        int[] leftHighest = new int[height.length], rightHighest = new int[height.length];
        leftHighest[0] = 0;
        rightHighest[rightHighest.length-1] = 0;
        //dp
        for (int i = 1; i < leftHighest.length; i++)
            leftHighest[i] = Integer.max(leftHighest[i - 1], height[i-1]); //***bug:(leftHeight[i - 1], height[i]);
        for (int i = leftHighest.length-1-1; i >= 0; i--)
            rightHighest[i] = Integer.max(rightHighest[i + 1], height[i+1]);
        //cal
        int curV ;
        int totalV = 0;
        for (int i = 0; i < height.length; i++) {
            curV = Integer.min(leftHighest[i], rightHighest[i]) - height[i];
            if (curV>0)
                totalV += curV;
        }

        return totalV;
    }

}
