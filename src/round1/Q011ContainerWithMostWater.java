package round1;
/**算法分析：本题基于贪心算法
 * 求最大的水缸体积（面积）
 * 设置双指针，初始化为0与length-1， 通过不断挪动指针，对解空间进行搜索。
 * 贪心算法起到的作用就是，能确定优化的方向，只向有可能达到全局最优解的方向进行搜索，从而免去不必要的搜索，降低时间复杂度
 * 
 * 具体算法：在搜索的全过程中，每次挪动分别有四种选择：front++，front--，rear++，rear--
 * 为了使得水缸的体积最大化，我们要最大化两个变量：1.两根柱子见的dist；2.较短柱子的长度
 * 我们将双指针初始化在边界处，就免去了front--与rear++的搜索方向（属于已搜索过的空间），只需向内搜索即可
 * 至于是选择front++还是rear--？基于贪心来做决定：向内搜索的过程中dist必定减小，想要使Area增大，只有让短边增加才有可能达到
 * 故：每次都挪动短边。
 * 
 * 哎其实具体怎么严谨地证明解空间已经搜索过了，实在想不明白，贪心本身就不好理解，先这样吧。
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
			//短边内移
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
	
	//以下为错误算法
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
