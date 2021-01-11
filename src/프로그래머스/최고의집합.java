package 프로그래머스;

import java.util.Arrays;

public class 최고의집합 {
	static class Solution {
	    public int[] solution(int n, int s) {
	        int[] answer = new int [n];
	        int[] nums = new int [n];
	        
	        
	        int num=s/n;
	        if(num<=0) {
	        	answer=new int[1];
	        	answer[0]=-1;
	        	return answer;
	        }
	        else {
	        	for(int i=0; i<n; i++) {
	        		nums[i]=num;
	        	}
	        	
	        	int plus=s%n;
	        	
	        	for(int i=n-1; i>=0; i--) {
	        		if(plus--<=0) break;
	        		nums[i]++;
	        	}
	        	
	        }
	        return nums;
	    }
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution().solution(2, 9)));
		System.out.println(Arrays.toString(new Solution().solution(2, 1)));
		System.out.println(Arrays.toString(new Solution().solution(2, 8)));
		System.out.println(Arrays.toString(new Solution().solution(4, 10)));
	}

}
