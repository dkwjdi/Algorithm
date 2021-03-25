package 프로그래머스_review;

public class n진수게임 {
	static class Solution {
	    public String solution(int n, int t, int m, int p) {
	    	StringBuilder answer= new StringBuilder();
	    	String []replace= {"A","B","C","D","E","F"};

	    	int number=-1;
	    	int turn=1;
	        while(true) {
	        	
	        	String numbers = CalJinsu(++number,n,replace);
	        	
	        	for(int i=0; i<numbers.length(); i++) {
	        		if(turn==p) { //튜브 순서라면 
	        			answer.append(numbers.charAt(i));
	        			if(--t==0) return answer.toString();
	        		}
	        		if(++turn==m+1) turn=1;
	        	}
	        }
	        
	    }

		private String CalJinsu(int quotient,int n, String[] replace) {
			if(quotient==0) return "0";
			
			StringBuilder sb= new StringBuilder();
			while(quotient>0) {
        		int remain=quotient%n;
        		quotient/=n;
        		
        		if(remain>=10) {
        			sb.append(replace[remain-10]);
        		}
        		else {
        			sb.append(remain);
        		}
        	}
			return sb.reverse().toString();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().solution(16,16, 2, 1));
		
	}
	

}
