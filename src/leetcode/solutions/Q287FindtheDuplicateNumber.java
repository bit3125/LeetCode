/**�㷨��������ָofferԭ��
 * ������������Ӷ�ΪO(nlogn)
 * ���Ӷ�ΪOn���㷨�����Ա������飬��ÿ�����ֶ����õ�����ֵ��Ӧ���±�λ��
 * �� ������ĳλ��������ȷ����ʱ�������ظ�����ֱ��return
 * 
 * */

package leetcode.solutions;

public class Q287FindtheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        if (nums==null||nums.length==0)
        	return -1;
        
        int idx = 0;
        while(idx<nums.length){
        	int curNum = nums[idx];//��ǰ����λ����(1.��ǿ�ɶ��ԣ�2.swapʱ��tmp������)
        	if (idx==curNum){//�жϵ�ǰ����λ�����Ƿ��Ѿ�������ȷλ���ϣ����ǵ�ǰ����ɹ�λ��i++
        		idx++;
        		continue;
        	}
        	//else
        	if (nums[curNum]==curNum){//��������λ���ֵ���ȷλ�ã��жϸ�λ���Ƿ������������������return
        		return curNum;
        	}else{
        		//swap->��λ
        		nums[idx] = nums[curNum];
        		nums[curNum] = curNum;
        	}
        }
        
    	return -1;//will never be execute
    }
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
