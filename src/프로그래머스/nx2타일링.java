package 프로그래머스;

public class nx2타일링 {
	static class Solution {
	    public int solution(int n) {
	        int answer = 1;
	        
	        int a=1;
	        int b=1;
	        
	        for(int i=1; i<n; i++) {
	        	answer=(a+b)%1000000007;
	        	a=b;
	        	b=answer;
	        }
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().solution(3));
	}

}
