package 프로그래머스;

import java.util.Arrays;

public class H_Index {
	static class Solution {
	    public int solution(int[] citations) {
	        int answer = 0;
	        
	        Arrays.sort(citations);
	        int size=citations.length;
	        
	        for(int i=0; i<size; i++) {
	        	if(citations[i]>=size-i) {
	        		answer=size-i;
	        		break;
	        	}
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int[] citations= {0,1,1};
		System.out.println(new Solution().solution(citations));
	}

}
