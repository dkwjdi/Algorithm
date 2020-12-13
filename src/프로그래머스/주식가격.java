package 프로그래머스;

import java.util.Arrays;
import java.util.Stack;

public class 주식가격 {
	static class Solution {
		class Info{
			int index,time,price;
			public Info(int index, int time,int price) {
				this.index = index;
				this.time = time;
				this.price = price;
			}
		}
	    public int[] solution(int[] prices) {
	        int[] answer = new int[prices.length];
	        Stack <Info> stack = new Stack<>();
	        int time=0;
	        
	        for(int i=0; i<prices.length; i++) {
	        	
	        	if(stack.isEmpty()) stack.add(new Info(i,time,prices[i]));
	        	else { //맨위에꺼 봤는데 나보다 크면 빼버리셈 그리고 내가 들어감 
	        		if(prices[i]<stack.peek().price) {
	        			
	        			while(true) {
	        				Info info=stack.pop();
	        				answer[info.index]=time-info.time;
	        				if(stack.isEmpty()|| prices[i]>=stack.peek().price) break;
	        			}
	        		}
	        		stack.add(new Info(i,time,prices[i]));
	        	}
	        	time++;
	        }
	        time--;
	        for(Info info : stack) {
	        	answer[info.index]=time-info.time;
	        }
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		int[] prices= {3,7,1,5,2,3,2};
		new Solution().solution(prices);
	}

}
