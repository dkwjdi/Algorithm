package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 기능개발 {
	static class Solution {
	    public int[] solution(int[] progresses, int[] speeds) {
	        
	        int len=progresses.length;
	        
	        
	        List<Integer> list = new ArrayList<>();
	        int start=0;
	        int cnt=0;
	        int arraysize=0;
	        while(true) {
	        	
	        	for(int i=start; i<len; i++) {
	        		progresses[i]+=speeds[i];
	        	}
	        	
	        	for(int i=start; i<len; i++) {
	        		if(progresses[i]>=100) {
	        			start++;
	        			cnt++;
	        		}
	        		else {
	        			break;
	        		}
	        	}
	        	if(cnt>0) {
	        		list.add(cnt);
	        		cnt=0;
	        		arraysize++;
	        	}
	        	
	        	if(start==len) break;
	        }
	        
	        int answer[]=new int[arraysize];
	        int s=list.size();
	        for(int i=0; i<s; i++) {
	        	answer[i]=list.get(i);
	        }
	        
	        System.out.println(Arrays.toString(answer));
	        
	        return answer;
	    }
	}
	

}
