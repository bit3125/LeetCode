/**算法分析：与Q448一毛一样
 * */
package round1;

import java.util.ArrayList;
import java.util.List;

public class Q442FindAllDuplicatesinanArray {

	//nums[n] 放 n+1 
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
    	if (nums==null || nums.length==0)
        	return result;
        	
    	//others.sort
    	int curNum, tmp;
    	for (int i=0;i<nums.length;){
    		curNum = nums[i];
    		if (curNum!=i+1){ //curNum没有放在应该的位置上
    			//try put nums[i] into right place
    			if (nums[curNum-1]==curNum){ //该位置已经有curNum了，curNum重复
    				i++;
    			}else{ //[i] 与 [curNum-1] swap
    				tmp = nums[curNum-1];
    				nums[curNum-1] = curNum;
    				nums[i] = tmp;
    			}
    		}else{ //nums[i]已经是归位好的了
    			i++;
    		}
    	}
    	
    	//cnt
    	for (int i=0;i<nums.length;i++){
    		if (nums[i]!=i+1)
    			result.add(nums[i]);
    	}
    	
    	return result;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
