package round1;
/**�㷨�������������̰���㷨
 * ������ˮ������������
 * ����˫ָ�룬��ʼ��Ϊ0��length-1�� ͨ������Ų��ָ�룬�Խ�ռ����������
 * ̰���㷨�𵽵����þ��ǣ���ȷ���Ż��ķ���ֻ���п��ܴﵽȫ�����Ž�ķ�������������Ӷ���ȥ����Ҫ������������ʱ�临�Ӷ�
 * 
 * �����㷨����������ȫ�����У�ÿ��Ų���ֱ�������ѡ��front++��front--��rear++��rear--
 * Ϊ��ʹ��ˮ�׵������󻯣�����Ҫ�������������1.�������Ӽ���dist��2.�϶����ӵĳ���
 * ���ǽ�˫ָ���ʼ���ڱ߽紦������ȥ��front--��rear++�����������������������Ŀռ䣩��ֻ��������������
 * ������ѡ��front++����rear--������̰���������������������Ĺ�����dist�ض���С����ҪʹArea����ֻ���ö̱����Ӳ��п��ܴﵽ
 * �ʣ�ÿ�ζ�Ų���̱ߡ�
 * 
 * ����ʵ������ô�Ͻ���֤����ռ��Ѿ��������ˣ�ʵ���벻���ף�̰�ı���Ͳ�����⣬�������ɡ�
 * 
 * */

public class Q011ContainerWithMostWater {
	
	public int maxArea(int[] height) {
		if (height==null||height.length<2)
			return 0;
		
		int front = 0, rear = height.length-1;
		int maxArea = Integer.MIN_VALUE;
		while(front!=rear){
			int curArea = calArea(height, front, rear);
			maxArea = Integer.max(curArea, maxArea);
			//�̱�����
			if (height[front]<height[rear])
				front++;
			else
				rear--;
		}
		
		return maxArea;
	}
	
    public int calArea(int[] height, int front, int rear){
    	return Math.abs(front-rear)*Math.min(height[front], height[rear]);
    }
	
	//����Ϊ�����㷨
//    public int maxArea(int[] height) {
//        if (height==null||height.length<2)
//        	return 0;
//        
//        int front = 0, rear = 1;
//        int maxArea = calArea(height, 0, 1);
//        for (int cur = 2;cur<height.length;cur++){
//        	
//        	//*******debugging
//        	System.out.println(front+","+rear);
//        	
//        	
//        	int newAreaF = calArea(height, cur, front);
//        	int newAreaR = calArea(height, cur, rear);
//        	int candidateIdx, candidateArea;
//        	
//        	//compare newAreaF with newAreaR
//        	if(newAreaF>newAreaR){
//        		candidateIdx = front;
//				candidateArea = newAreaF;
//        	}else{
//        		candidateIdx = rear;
//        		candidateArea = newAreaR;
//        	}
//        	//compare candidateArea with maxArea
//        	if (candidateArea>maxArea){
//        		maxArea= candidateArea;
//        		front = candidateIdx;
//        		rear = cur;
//        	}
//        	
//        }
//        
//        return maxArea;
//    }
    
	public static void main(String[] args) {
		Q011ContainerWithMostWater q = new Q011ContainerWithMostWater();
		int[] height = {2,3,10,5,7,8,9};
		
		System.out.println(q.maxArea(height));
	}

}
