package 프로그래머스;

public class 숫자의표현 {
	static class Solution {
	    public int solution(int n) {
	        int answer = 0;
	        int sum=0;
	        
	        for(int i=1; i<=n/2; i++) { //절반까지 
	        	sum=i;
	        	int j=i;
	        	while(true) {
	        		j++;
	        		sum+=j;
	        		if(sum==n) {
	        			answer++;
	        			break;
	        		}
	        		if(sum>n) break;
	        	}
	        	
	        	
	        }
	        
	        
	        return answer+1;
	    }
	}
	public static void main(String[] args) {
		System.out.println(new Solution().solution(15));
	}

}
