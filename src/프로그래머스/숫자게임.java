package 프로그래머스;

import java.util.Arrays;

public class 숫자게임 {
	static class Solution {
	    public int solution(int[] A, int[] B) {
	        int answer = 0;
	        
	        Arrays.sort(A);
	        Arrays.sort(B);
	        
	        int aIdx=0;
	        int bIdx=0;
	        int size=A.length;
	        
	        while(true) {
	        	if(A[aIdx]<B[bIdx]) {
	        		answer++;
	        		aIdx++;
	        		bIdx++;
	        	}
	        	else bIdx++;
	        	
	        	if(aIdx==size || bIdx==size) break;
	        }
	        
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		int[] A= {1,1,1,1};
		int[] B= {2,2,2,2};
		
		System.out.println(new Solution().solution(A, B));
	}

}
