package 프로그래머스;

public class 피보나치수 {
	static class Solution {
	    public int solution(int n) {
	        
	        int a=0;
	        int b=1;
	        
	        for(int i=0; i<n-1; i++) {
	        	int num=(a+b)%1234567;
	        	
	        	a=b;
	        	b=num;
	        }
	        return b;
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().solution(3));
	}

}
