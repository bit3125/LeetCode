package leetcode.solutions;

public class Q275HIndexII {

    public int hIndex(int[] citations) {
         if (citations==null||citations.length==0)
        	 return 0;
         
         for (int h=citations.length;h>=0;h--){
        	 int front = searchNoLessThan(citations, h, 0, citations.length-1);
        	 int rear = searchNoMoreThan(citations, h, 0, citations.length-1);
        	 int dupCnt = rear-front+1;
        	 
        	 int cnt = citations.length-front;//>=h�����ĸ���
//        	 if (h==0){
//        		 System.out.println(front);
//        		 System.out.println(rear);
//        		 System.out.println(dupCnt);
//        		 System.out.println(cnt);
//        		 
//        	 }
        	 if (cnt-dupCnt<=h && h<=cnt)
        		 return h;
         }
         
         return -1;
    }
    
	/* �ȷָ���������У�<������>=���С�
	 * return >=���е����ױ�ǩ
	 * Ȼ���ٶ�==�ĸ�������cnt��
	 * �ֳ�����ģ����У����Լ�С�㷨�ĸ��ӳ̶�
	 * 
	 * */
    public int searchNoLessThan(int[] array, int target, int front, int rear){

    	if (array[front]>=target)// all >=
    		return front;
    	if (array[rear]<target) //all <
    		return rear+1;

    	int mid;
    	while(rear-front>1){
    		mid = (front+rear)/2;
    		if (array[mid]<target){
    			front = mid;
    		}else if(array[mid]>=target){
    			rear = mid;
    		}
    	}
    	
    	return rear;
    }
    
    public int searchNoMoreThan(int[] array, int target, int front, int rear){

    	if (array[front]>target)// all >
    		return front;
    	if (array[rear]<=target) //all <=
    		return rear+1;

    	int mid;
    	while(rear-front>1){
    		mid = (front+rear)/2;
    		if (array[mid]<=target){
    			front = mid;
    		}else if(array[mid]>target){
    			rear = mid;
    		}
    	}
    	
    	return rear;
    }
    
	public static void main(String[] args) {
		Q275HIndexII q = new Q275HIndexII();
		int[] citations = {0,1,3,5,6};
//		int[] citations = {0};
		System.out.println(q.hIndex(citations));;
		
	}

}
