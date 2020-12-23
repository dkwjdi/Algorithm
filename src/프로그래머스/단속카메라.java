package 프로그래머스;

import java.util.Arrays;

public class 단속카메라 {
	static class Solution {
	    public int solution(int[][] routes) {
	        int answer = 0;
	        Arrays.sort(routes, (o1,o2)->(o1[0]-o2[0]));
	        
	        int start=routes[0][0],end=routes[0][1];
	        for(int i=1; i<routes.length; i++) {
	        	if(routes[i][0]<=end) start=routes[i][0];
	        	else {
	        		answer++;
	        		 start=routes[i][0];
	        		 end=routes[i][1];
	        	}
	        	
	        	if(end>=routes[i][1]) end=routes[i][1];
	        }
	        return answer+1;
	    }
	}
	public static void main(String[] args) {
		int[][] routes= {
				{-20,15}, 
				{-14,-5}, 
				{-18,-13}, 
				{-5,-3}
		};
		System.out.println(new Solution().solution(routes));
	}

}
