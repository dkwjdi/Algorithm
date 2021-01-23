package 프로그래머스;

public class 올바른괄호 {
	static class Solution {
	    boolean solution(String s) {
	        boolean answer = true;
	        int check=0;
	        
	        for(int i=0; i<s.length(); i++) {
	        	char ch=s.charAt(i);
	        	if(ch=='(') check++;
	        	else check--;
	        	
	        	if(check<0) return false;
	        }
	        if(check!=0) return false;
	        return answer;
	    }
	}
	public static void main(String[] args) {
		System.out.println(new Solution().solution("(())()"));
		
	}

}
