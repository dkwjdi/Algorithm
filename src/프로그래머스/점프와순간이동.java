package 프로그래머스;

public class 점프와순간이동 {
	static public class Solution {
	    public int solution(int n) {
	        int ans = 0;
	        
	        while(n!=1) {
	        	if(n%2==0) n/=2; //짝수면 절반으로 
	        	else {  //홀수면 -1 해주고 건전지++
	        		n-=1;
	        		ans++;
	        	}
	        }
	        return ans+1;
	    }
	}
	public static void main(String[] args) {
		
	}

}
