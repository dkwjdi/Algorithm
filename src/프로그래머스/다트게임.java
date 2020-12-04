package 프로그래머스;

public class 다트게임 {
	static class Solution {
	    public int solution(String dartResult) {
	        
	        int result[]=new int[3];
	        
	        int idx=-1;
	        for(int i=0; i<dartResult.length(); i++) {
	        	char data=dartResult.charAt(i);
	        	if(Character.isDigit(data)) {
	        		idx++;
	        		if(Character.isDigit(dartResult.charAt(i+1))) { // 10체크
	        			result[idx]=Integer.parseInt(dartResult.substring(i, i+2));
	        			i++;
	        		}
	        		else result[idx]=data-'0';
	        	}
	        	else if(data=='S') {
	        		result[idx]=(int) Math.pow(result[idx], 1);
	        	}
	        	else if(data=='D') {
	        		result[idx]=(int) Math.pow(result[idx], 2);
	        	}
	        	else if(data=='T') {
	        		result[idx]=(int) Math.pow(result[idx], 3);
	        	}
	        	else if(data=='*') {
	        		result[idx]*=2;
	        		if(idx!=0) result[idx-1]*=2;
	        	}
	        	else if(data=='#') {
	        		result[idx]=-result[idx];
	        	}
	        	
	        }
	        return result[0]+result[1]+result[2];
	    }
	    
	}
	public static void main(String[] args) {
		String dartResult="1D2S3T*";
		new Solution().solution(dartResult);
	}
	
	

}
