/**�㷨��������Q448һëһ��
 * */
package round1;

import java.util.ArrayList;
import java.util.List;

public class Q442FindAllDuplicatesinanArray {

	//nums[n] �� n+1 
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
    	if (nums==null || nums.length==0)
        	return result;
        	
    	//others.sort
    	int curNum, tmp;
    	for (int i=0;i<nums.length;){
    		curNum = nums[i];
    		if (curNum!=i+1){ //curNumû�з���Ӧ�õ�λ����
    			//try put nums[i] into right place
    			if (nums[curNum-1]==curNum){ //��λ���Ѿ���curNum�ˣ�curNum�ظ�
    				i++;
    			}else{ //[i] �� [curNum-1] swap
    				tmp = nums[curNum-1];
    				nums[curNum-1] = curNum;
    				nums[i] = tmp;
    			}
    		}else{ //nums[i]�Ѿ��ǹ�λ�õ���
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
		// TODO �Զ����ɵķ������

	}

}
