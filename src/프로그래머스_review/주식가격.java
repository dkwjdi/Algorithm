package 프로그래머스_review;

import java.util.Arrays;
import java.util.Stack;

public class 주식가격 {
	static class Solution {
		class Info{
			int num,time,index;
			public Info(int index,int num, int time) {
				this.index=index;
				this.num = num;
				this.time = time;
			}
			
		}
	    public int[] solution(int[] prices) {
	        int[] answer = new int[prices.length];
	        
	        Stack <Info> stack = new Stack<>();
	        int time=0;
	        
	        for(int i=0; i<prices.length; i++) {
	        	time++;
	        	int price=prices[i];
	        	if(stack.isEmpty()) stack.push(new Info(i,price, time));
	        	else { //안비어있으면
	        		while(true) {
	        			if(stack.isEmpty() || stack.peek().num<=price) {
	        				stack.push(new Info(i,price,time));
	        				break;
	        			}
	        			else if(stack.peek().num>price) {
	        				Info end=stack.pop();
	        				answer[end.index]=time-end.time;
	        			}
	        		}
	        	}
	        }
	        
	        while(!stack.isEmpty()) {
	        	Info end=stack.pop();
	        	answer[end.index]=time-end.time;
	        }
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution().solution(new int[] {5,4,5,1,2})));
	}

}
