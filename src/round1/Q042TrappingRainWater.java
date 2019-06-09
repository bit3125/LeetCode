/**算法分析：基于DP的算法，Tn = On， Sn = On
 * 每个bin能够存储的水量，取决于它的lowestBound[i] = Integer.max(leftHighestBar[i], rightHighestBar[i])。若它比lowestBound矮
 * ，则其蓄水量为height[i]-lowestBound[i]
 *
 * 建立两个DP数组：leftHighest rightHighest，分别计算
 * 然后再进行一次遍历，计算出每个bin的蓄水量，累加
 *
 * 还有Tn=On, Sn=O1的算法，不再研究
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
