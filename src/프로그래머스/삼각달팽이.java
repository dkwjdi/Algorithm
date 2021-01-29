package 프로그래머스;

import java.util.ArrayList;
import java.util.List;

public class 삼각달팽이 {
	static class Solution {
	    public int[] solution(int n) {
	        int[] answer = {};
	        
	        List <Integer> list[] = new List[n+1];
	        for(int i=0; i<=n; i++) list[i]=new ArrayList<>();
	        
	        int plusNum=n+1+(n-3)*2;
	        int minusNum=plusNum;
	        System.out.println(plusNum);
	        
	        for(int i=1; i<=n; i++) {
	        	if(i==1) list[i].add(i);
	        	
	        	else {
	        		for(int j=0; j<i; j++) {
	        			if(j==0) list[i].add(i);
	        			else if(j==i-1) list[i].add(minusNum--);
	        			else {
	        				
	        			}
	        		}
	        		
	        	}
	        	
	        	
	        }
	        
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		new Solution().solution(6);
	}

}
