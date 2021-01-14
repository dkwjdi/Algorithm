package 프로그래머스;

import java.util.Arrays;

public class 땅따먹기 {
	static class Solution {
	    int solution(int[][] land) {
	        int answer = 0;
	        
	        for(int i=1; i<land.length; i++) {
	        	for(int j=0; j<4; j++) {
	        		int num=land[i][j];
	        		for(int k=0;k<4; k++) {
	        			if(j==k) continue;
	        			land[i][j]=Math.max(land[i][j], num+land[i-1][k]);
	        		}
	        		
	        	}
	        }
	        return Arrays.stream(land[land.length-1]).max().getAsInt();
	    }
	}
	public static void main(String[] args) {
		int[][] land= {
				{1,2,3,5},{5,6,7,8},{4,3,2,1}
		};
		System.out.println(new Solution().solution(land));
		
	}

}
