/**算法分析： Tn = Ologn
 *
 * 使用Binary Search，while条件front<=rear,
 * bs的本质是圈定一个范围，然后不断根据mid的判断条件将下一步的搜索范围缩小到肯定能找到target的新范围中
 *
 * 让front与rear分别指向可能找到target的序列的左边界与右边界 [inclusive, inclusive]，
 * 故此时while条件就可以设为front<rear，意为把front与rear包括在内都搜个遍
 * 我们要寻找的peek其实就是local max，满足两个条件：
 * 1. 0 == mid || nums[mid - 1] < nums[mid] ，左侧条件
 * 2. nums.length - 1 == mid || nums[mid] > nums[mid + 1]， 右侧条件
 * 故用两个if分支对两个条件做判断
 * 1. 若不满足左侧条件，则mid必定不是target，且[0,mid-1]中必定有满足条件的target（因为区间右端点导数为负且左端点->-∞）
 * 故可将搜索范围缩小至[0, mid-1]
 * 2. 若不满足右侧条件，则mid必定不是target，且[mid+1, nums.length-1]中必定有满足条件的target（因为区间左端点导数为正且右端点->-∞）
 * 故可将搜索范围缩小至[mid+1, nums.length-1]
 * 以此类推直至找到target
 *
 * */
package round1;

public class Q162FindPeakElement_Solution2 {
    public int findPeakElement(int[] nums) {
        if (nums==null||nums.length==0)
            return -1;

        int front = 0, rear = nums.length - 1;
        int mid;
        while (front <= rear) {
            mid = (front + rear) / 2;
            if (!(0 == mid || nums[mid - 1] < nums[mid])) {//mid左侧不满足
                rear = mid-1;
            } else if (!(nums.length - 1 == mid || nums[mid] > nums[mid + 1])) { //mid右侧不满足
                front = mid+1;
            } else  //左右侧皆满足
                return mid;
        }
        return -1;
    }

}
