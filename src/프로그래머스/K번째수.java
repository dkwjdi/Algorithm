package 프로그래머스;

import java.util.Arrays;

public class K번째수 {
	static class Solution {
	    public int[] solution(int[] array, int[][] commands) {
	        int[] answer = new int[commands.length];
	        
	        for(int i=0; i<commands.length; i++) {
	        	int []copy=new int[commands[i][1]-commands[i][0]+1];
	        	System.arraycopy(array, commands[i][0]-1, copy, 0,commands[i][1]-commands[i][0]+1);
	        	Arrays.sort(copy);
	        	answer[i]=copy[commands[i][2]-1];
	        }
	        
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		int[] array= {1, 5, 2, 6, 3, 7, 4};
		int[][] commands= {
				{2, 5, 3},
				{4, 4, 1}, 
				{1, 7, 3}
		};
		System.out.println(new Solution().solution(array, commands));
	}
}
