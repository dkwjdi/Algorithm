package 프로그래머스_review;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 프린터 {
	static class Solution {
	    public int solution(int[] priorities, int location) {
	        int answer = 0;
	        Queue <Integer> priority = new LinkedList<>(); //중요도
	        PriorityQueue <Integer> sortPriority = new PriorityQueue<Integer>(Collections.reverseOrder());
	        Queue <Integer> index = new LinkedList<>();    //인덱스
	        
	        for(int i=0; i<priorities.length; i++) {
	        	index.offer(i);
	        	priority.offer(priorities[i]);
	        	sortPriority.offer(priorities[i]);
	        }
	        
	        int cnt=0;
	        while(!priority.isEmpty()) {
	        	int pri=priority.poll(); //프린터 하나 뽑기
	        	int idx=index.poll();
	        	if(pri==sortPriority.peek()) { //현재 뽑는게 가장 높은 우선순위를 가진다면 
	        		cnt++;
	        		sortPriority.poll();
	        		if(idx==location) { //찾으면 
	        			answer=cnt;
	        			break;
	        		}
	        	}
	        	else { //우선순위 더 높은게 있다면 다시 넣어주기
	        		priority.offer(pri);
	        		index.offer(idx);
	        	}
	        }
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int[] priorities= {1,1,9,1,1,1};
		System.out.println(new Solution().solution(priorities, 0));
	}

}
