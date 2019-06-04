package leetcode.solutions;
import java.util.ArrayList;

public class Q069Sqrtx {

	private static int LEFT_BOUND = 0;
	private static int RIGHT_BOUND = 46341;
	public int mySqrt(int x) {
		
		int front = LEFT_BOUND;
		int rear = RIGHT_BOUND;
		int mid, midSquare;
		while(rear-front>1){ //***bug:front<rear 卡在rear-front==1死循环
			mid = (front+rear)/2;
			midSquare = mid*mid;
			if (midSquare==x){
				return mid;
			}else if (midSquare>x){
				rear = mid;
			}else{ //midSquare<x
				front = mid;
			}
		}//front永远指向小于的子列，rear永远指向大于的子列，最后他俩指向边界
		
		return front;
	}
	
	public static void main(String[] args) {
		Q069Sqrtx q = new Q069Sqrtx();
		int x = 8;
		System.out.println(q.mySqrt(x));
	}

}

//46340.95->46340