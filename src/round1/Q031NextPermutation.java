/**�㷨���������η���
 * ����s[i,len]Ϊnums.substring(i, nums.length)  (,]
 * core�������ڵõ�s[curIdx, len]��next permutation��return �ɹ����
 * ���õ�s[curIdx, len]�ֵõݹ����core����ȥ���Եõ�s[curIdx+1,len]�����ɹ�����ɣ���ʧ�������������Σ�
 * s[curIdx+1,len]�Ѿ�����������Ԫ�ص�����ֵ���ȫ�������У���s[0,curIdx+1]����Զ����������Ԫ�ص���С�ֵ���
 * ���ʴ�ʱҪ�õ���һ��ȫ����Ҫ���ľ�����s[0,curIdx+1]���ֵ���������Сֵ������s[curIdx+1,len]��Ѱ����С��
 * �����nums[curIdx]���Ԫ�ؽ���swap��Ȼ���s[curIdx+1,len]�����������еõ�����С�ֵ������У���ʱ��͵õ�
 * ����һ��ȫ����return true�����������û��һ��Ԫ�����㣬��˵��s[curIdx,len]Ҳ�Ѿ�������ֵ����Ӵ���return false
 * 
 * */

package round1;

import java.util.Arrays;

public class Q031NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums==null || nums.length==0)
        	return;
        
        if (!nextPermutationCore(nums, 0))
        	Arrays.sort(nums);
    }
    
    /**���ڵõ�idxλ��ʼ(inclusive)���Ӵ���nextȫ����
     * 
     * return : �Ƿ�ɹ��õ�
     * ����s[i,len]Ϊnums.substring(i, nums.length)  (,]
     * */
    public boolean nextPermutationCore(int[] nums, int curIdx){
    	if(curIdx>=nums.length-1) //�ݹ����
    		return false;
    	
    	if (nextPermutationCore(nums, curIdx+1)) //s[curIdx+1,len]�õ���next permutation
    		return true;
    	else { //s[curIdx+1,len] �Ѿ����Ӵ������һ��ȫ����(��ȫ����)
    		for (int i=nums.length-1;i>curIdx;i--){ //���Խ�s[curIdx+1,len]�Ӻ���ǰ����
    			//����Ѱ��С�������׸���nums[curIdx]�������ʹ�����㡰��s[0, curIdx+1]��nums[curIdx]��������s[0, curIdx+1]���ֵ�������Сֵ��
    			//��Ҫ������󣬵����־���Ҫ��������С����
    			if (nums[curIdx]<nums[i]){ //�ҵ�������������СԪ�أ���nums[curIdx] swap
    				swap(nums, curIdx, i); 
    				Arrays.sort(nums, curIdx+1, nums.length);//�����������λ�Ӵ�s[curIdx+1,len]�������С�ֵ����Ӵ�
    				return true;
    			}
    		}
    		return false; //����������Ҳ�Ҳ�������������һ��Ԫ�أ� ˵��s[curIdx,len]Ҳ�Ѿ�������ֵ���ȫ�����Ӵ�
    		//��return false�������ϲ�ȥ����
    	}
    }
    
    public void swap(int[] nums, int idx1, int idx2){
    	int tmp = nums[idx1];
    	nums[idx1] = nums[idx2];
    	nums[idx2] = tmp;
    }
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
