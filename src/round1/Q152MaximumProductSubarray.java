/**算法分析：典型DP
 * TODO TODO
 * 
 * */

package round1;

import java.util.Arrays;

public class Q152MaximumProductSubarray {

	public int maxProduct(int[] nums) {
        if (nums==null||nums.length==0)
        	return 0;
        
        int maxProdPrev;
        int minProdPrev;
        int[] tmp = new int[3];
        int maxProd;
        
        maxProdPrev = nums[0];
        minProdPrev = nums[0];
        maxProd = nums[0];
        for (int i=1;i<nums.length;i++){
        	tmp[0] = maxProdPrev*nums[i];
        	tmp[1] = minProdPrev*nums[i];
        	tmp[2] = nums[i];
        	Arrays.sort(tmp);
        	minProdPrev = tmp[0];
        	maxProdPrev = tmp[2];
        	
        	if (maxProd<maxProdPrev)
        		maxProd = maxProdPrev;
        }
        
        return maxProd;
    }
	
//    public int maxProduct(int[] nums) {
//        if (nums==null||nums.length==0)
//        	return 0;
//        
//        int[] maxProds = new int[nums.length];
//        int[] minProds = new int[nums.length];
//        int[] tmp = new int[3];
//        
//        maxProds[0] = nums[0];
//        minProds[0] = nums[0];
//        for (int i=1;i<nums.length;i++){
//        	tmp[0] = maxProds[i-1]*nums[i];
//        	tmp[1] = minProds[i-1]*nums[i];
//        	tmp[2] = nums[i];
//        	Arrays.others.sort(tmp);
//        	minProds[i] = tmp[0];
//        	maxProds[i] = tmp[2];
//        }
//        
//        int maxProd=Integer.MIN_VALUE;
//        for (int i=0;i<nums.length;i++){
//        	if (maxProd<maxProds[i])
//        		maxProd = maxProds[i];
//        }
//        return maxProd;
//    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
