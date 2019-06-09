/**算法分析：借用“0~n的数放在大小为n的数组中，寻找重复的数字”的算法
 * 原题中一个指针从头扫描到尾，指针左侧都是已经归位好的数
 * 不一样的在于，本题中稍作改动，当找到重复数字的时候不直接return，而是让指针继续右移，也即左侧不再是归位好的数也可能是重复的数
 * 最后再花On的时间扫描一遍数组，data与index对不上的即为所求
 * 
 * */

package round1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q448FindAllNumbersDisappearedinanArray {
	//nums[n] 放 n+1 
    public List<Integer> findDisappearedNumbers(int[] nums) {
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
    			result.add(i+1);
    	}
    	
    	return result;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
