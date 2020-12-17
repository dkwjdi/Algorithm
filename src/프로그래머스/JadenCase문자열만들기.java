package 프로그래머스;

public class JadenCase문자열만들기 {
	static class Solution {
	    public String solution(String s) {
	        String answer = "";
	        
	        String []str=s.toLowerCase().split(" ");
	        
	        for(int i=0; i<str.length; i++) {
	        	String str2=str[i];
	        	if(str2.equals("")) {
	        		answer+=" ";
	        		continue;
	        	}
	        	char ch=str2.charAt(0);
	        	if(!((ch<'a' ||ch>'z') && (ch<'A' || ch>'Z'))) {
	        		String head=str2.substring(0,1).toUpperCase();
	        		String body=str2.substring(1);
	        		answer+=head+body;
	        	}
	        	else answer+=str2;
	        	
	        	answer+=" ";
	        		
	        	
	        	
	        }
	        int answerlen=answer.length();
	        int slen=s.length();
	        
	        if(answerlen-1 < slen ) {
	        	for(int i=0; i<=s.length()-answer.length(); i++)
	        		answer+=" ";
	        	
	        }
	        return answer.substring(0, answer.length()-1);
	    }
	}
	public static void main(String[] args) {
		System.out.println(new Solution().solution("Fft  "));
	}

}
