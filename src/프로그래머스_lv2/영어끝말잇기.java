package 프로그래머스_lv2;

import java.util.Arrays;
import java.util.HashSet;

public class 영어끝말잇기 {
	static class Solution {
	    public int[] solution(int n, String[] words) {
	        int[] answer = {0,0};
	        
	        int no=1;
	        int turn=1;
	        HashSet<String> check = new HashSet<>();
	        char lastChar=words[0].charAt(0);
	        
	        for(int i=0; i<words.length; i++) {
	        	String word=words[i];
	        	if(lastChar!=word.charAt(0) || check.contains(word)) {
	        		answer[0]=no;
	        		answer[1]=turn;
	        		break;
	        	}
	        	lastChar=word.charAt(word.length()-1);
	        	check.add(word);
	        	
	        	if(no++==n) {
	        		no=1;
	        		turn++;
	        	}
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		String [] words= {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
		System.out.println(Arrays.toString(new Solution().solution(3, words)));
	}

}
