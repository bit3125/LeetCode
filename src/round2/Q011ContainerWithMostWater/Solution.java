/**算法分析：r1定义为贪心算法，这里认为是剪枝后的动态规划
 * 暴力穷举共有n^2种组合。现考虑将复杂度优化至线性
 * 将两个游标初始化在首尾
 * Area由两个因素决定：1.Integer.min(height[left], height[right]) ；2.dist = right - left
 * 故两个游标向内部搜索时，dist在减小，故只有短边变长才有可能让Area增大，
 * 故应该让短边内移进行搜索，
 * 在短边内移过程中，长边固定不动，长边内移与短边内移的部分组合直接被剪枝掉了，正是因为这个原因大量剪枝
 *
 * 使用一个while循环来进行搜索，每次都内移短边，最终用线性的复杂度得到最优解
 *
 * */

package round2.Q011ContainerWithMostWater;

class Solution {
    public int maxArea(int[] height) {
        if (height==null || height.length==0)
            return 0;

        int left = 0, right = height.length-1;
        int curArea, maxArea = Integer.min(height[left], height[right]) * (right - left);

        while (left<right) {
            if (height[left] < height[right])
                left++;
            else
                right--;
            curArea = Integer.min(height[left], height[right]) * (right - left);
            maxArea = Integer.max(curArea, maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,4,5,18,17,6};
        Solution sl = new Solution();
        System.out.println(sl.maxArea(nums));;
    }
}