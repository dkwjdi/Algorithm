package 프로그래머스;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 수식최대화 {
	static class Solution {
	    public long solution(String expression) {
	    	char priority[][]= {
	    			{'*','+','-'},
	    			{'*','-','+'},
	    			{'+','*','-'},
	    			{'+','-','*'},
	    			{'-','*','+'},
	    			{'-','+','*'},
	    	};
	    	
	        String num="";
	        List<Long> nums=new ArrayList<>();
	        List<Character> ops=new ArrayList<>();
	        
	        for(int i=0; i<expression.length(); i++) {
	        	char ch=expression.charAt(i);
	        	if(Character.isDigit(ch)) num+=ch; //숫자라면 
	        	else { //숫자 아니라면
	        		ops.add(ch);
	        		nums.add(Long.parseLong(num));
	        		num="";
	        	}
	        }
	        nums.add(Long.parseLong(num));
	        return solve(nums,ops,priority);
	    }

		private long solve(List<Long> nums, List<Character> ops, char[][] priority) {
			char opCheck='+';
			long answer=0;
			
			for(int k=0; k<6; k++) {
				Stack<Long> num=new Stack<>();
				Stack<Character> op=new Stack<>();
				for(int i=0; i<nums.size(); i++) {
					num.add(nums.get(i));
					if(i!=nums.size()-1) {
						opCheck=ops.get(i);
						//우선순위가 나보다 같거나 높은 우선순위  위로는 못들어감 !!!!
						while(true) {
							if(op.isEmpty() || priorityCheck(op.peek(), opCheck,k,priority)) { //연산자 잘 들어간다면 !
								op.add(opCheck);
								break;
							}
							else { //빼서 계산 ㄱ
								long b=num.pop();
								long a=num.pop();
								num.push(cal(a,b,op.pop()));
							}
						}
					}
				}
				
				//남은 연산자수만큼 계산 
				int size=op.size();
				for(int i=0; i<size; i++) {
					long b=num.pop();
					long a=num.pop();
					num.push(cal(a,b,op.pop()));
				}
				answer = Math.max(Math.abs(num.pop()), answer);
			}
			return answer;
		}

		private long cal(long a, long b, char pop) {
			switch(pop) {
			case '+': return a+b;
			case '-': return a-b;
			case '*': return a*b;
			}
			return 0;
		}

		private boolean priorityCheck(char peek, char opCheck,int k, char[][] priority) {
			int peekPriority=0;
			int opCheckPriority=0;
			
			for(int i=0; i<3; i++) {
				if(priority[k][i]==peek) peekPriority=i; //현재 스택에 들어가있는 값
				if(priority[k][i]==opCheck) opCheckPriority=i; //들어갈 값 
			}
			if(peekPriority > opCheckPriority) return true;
			return false;
		}
	}
	public static void main(String[] args) {
		System.out.println(new Solution().solution("50*6-3*2"));
	}

}
