package round4.q011ContainerWithMostWater;

class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }

        int maxArea = Integer.MIN_VALUE, maxHeightLeftIdx = 0;
        for (int i = 1; i < height.length; i++) {
            maxArea = Integer.max(maxArea, (i - maxHeightLeftIdx) * Integer.min(height[maxHeightLeftIdx], height[i]));
            if (height[i] > height[maxHeightLeftIdx]) {
                maxHeightLeftIdx = i;
            }
        }

        return maxArea;
    }
}