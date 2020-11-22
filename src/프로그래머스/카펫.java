package 프로그래머스;

import java.util.Arrays;

public class 카펫 {
	static class Solution {
	    public int[] solution(int brown, int yellow) {
	        
	        int size=brown+yellow;
	        
	        
	        int a=0;
	        int b=0;
	        for(int i=3; (i*i)<=size; i++) {
	        	if(size%i==0) {
	        		a=i;
	        		b=size/i;
	        		
	        		if(check(Math.max(a, b),Math.min(a, b),size,brown,yellow)) break;
	        	}
	        }
	        
	        int [] answer = {Math.max(a, b), Math.min(a, b)};
	        System.out.println(Arrays.toString(answer));
	        return answer;
	    }

		private boolean check(int a, int b, int size,int brown, int yellow) { //a 큰거 b작은거
			int max=a;
			int min=b;
			
			int sum=0;
			while(true) {
				sum+=(max*2)+(min*2)-4;
				
				max--;
				min-=2;
				
				if(min<=2) {
					if(sum==brown && yellow==(a*b)-sum) {
						return true;
					}
					return false;
				}
			}
			
			
		}
	}
	public static void main(String[] args) {
		new Solution().solution(24,24
				
				);
	}

}
