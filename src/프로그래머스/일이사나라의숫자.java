package 프로그래머스;

public class 일이사나라의숫자 {
	static class Solution {
	    public String solution(int n) {
	        String answer = "";
	        StringBuilder sb= new StringBuilder();
	        while(n>=3) {
	        	if(n%3==0) {
	        		sb.append("4");
	        		n=(n/3)-1;
	        	}
	        	else {
	        		sb.append(Integer.toString(n%3));
	        		n/=3;
	        	}
	        }
	        if(n!=0) sb.append(Integer.toString(n));
	        answer=sb.reverse().toString();
	        //System.out.println(answer);
	        return answer;
	    }
	}
	public static void main(String[] args) {
		System.out.println(new Solution().solution(13));
		
	}

}
