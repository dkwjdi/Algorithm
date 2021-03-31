package 프로그래머스_review;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class 전화번호목록 {
	static class Solution {
	    public boolean solution(String[] phone_book) {
	        boolean answer = true;
	        
	        Arrays.sort(phone_book);
	        
	        int len[]=new int[phone_book.length];
	        Set <String> set =new HashSet<>();
	        
	        for(int i=0; i<phone_book.length; i++) {
	        	len[i]=phone_book[i].length(); //현재 단어의 길이
	        	
	        	for(int j=0; j<i; j++) {
	        		if(phone_book[i].length()<len[j]) continue;
	        		if(set.contains(phone_book[i].substring(0,len[j]))) {
	        			answer=false;
	        		}
	        	}
	        	
	        	if(!answer) break;
	        	set.add(phone_book[i]);
	        }
	        
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		String[] phone_book={"3456456464644566","2","55"};
		System.out.println(new Solution().solution(phone_book));
	}

}
