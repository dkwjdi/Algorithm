package 프로그래머스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 추석트래픽 {
	static class Solution {
	    public int solution(String[] lines) {
	        int answer = 0;
	        
	        for(int i=0; i<1; i++) {
	        	StringBuilder sb = new StringBuilder(lines[i]);
	        	sb.replace(lines[0].length()-1,lines[0].length() , "");
	        	sb.replace(0, 17, "");
	        	
	        	StringTokenizer st=new StringTokenizer(sb.toString());
	        	double one=Double.parseDouble(st.nextToken());
	        	double two=Double.parseDouble(st.nextToken());
	        	System.out.println(one-two);
	        	
	        }
	        
	        
	        
	        
	        
	        
	        System.out.println(lines[0].length());
	        System.out.println(3);
	        return answer;
	    }
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[]=new String[10];
		for(int i=0; i<1; i++) input[i]=br.readLine();
		System.out.println(new Solution().solution(input));
	}

}
