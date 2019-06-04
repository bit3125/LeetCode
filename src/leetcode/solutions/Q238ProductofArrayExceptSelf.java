/**算法分析：
 * 主要考虑好除零的问题
 * 
 * */
package leetcode.solutions;

public class Q238ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        if(nums==null||nums.length==0)
        	return null;

        int zeroCnt = 0;
        int[] prods = new int[nums.length];
        int prod = 1;
        for (int i=0;i<nums.length;i++){
        	if (nums[i]==0){
        		zeroCnt++;
        	}else
        		prod *= nums[i];
        }
        
        for (int i=0;i<nums.length;i++){
        	if (nums[i]==0){
        		prods[i] = zeroCnt>1?0:prod; 
        	}else{//nums[i]!=0
        		prods[i] = zeroCnt>0?0:prod/nums[i]; 
        	}
        }
        
        return prods;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
