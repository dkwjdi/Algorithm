package 프로그래머스;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 튜플 {
	static class Solution {
	    public int[] solution(String s) {
	        
	        String []tmp=s.split("\\{");
	        String []str=new String[tmp.length-2];
	        for(int i=0; i<str.length; i++) {
	        	str[i]=tmp[i+2].substring(0, tmp[i+2].length()-2);
	        }
	        
	        int[] answer = new int[str.length];
	        Set <String> set = new HashSet<>();
	        Arrays.sort(str, (o1,o2)-> o1.length()-o2.length());
	        
	        for(int i=0; i<str.length; i++) {
	        	String [] divide=str[i].split(",");
	        	for(int j=0; j<divide.length; j++) {
	        		if(set.contains(divide[j])) continue;
	        		answer[i]=Integer.parseInt(divide[j]);
	        		set.add(divide[j]);
	        	}
	        }
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution().solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
		
	}

}
