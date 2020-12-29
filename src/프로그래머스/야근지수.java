package 프로그래머스;

import java.util.PriorityQueue;

public class 야근지수 {
	static class Solution {
	    public long solution(int n, int[] works) {
	        long answer = 0;
	        PriorityQueue<Integer> maxPq=new PriorityQueue<Integer>((o1,o2)->(o2-o1));
	        long sum=0;
	        
	        for(int i=0; i<works.length; i++) {
	        	maxPq.offer(works[i]);
	        	sum+=works[i];
	        }
	        
	        if(sum<=n) return 0;
	        
	        for(int i=0; i<n; i++) {
	        	int work=maxPq.poll();
	        	maxPq.offer(--work);
	        }
	        
	        while(!maxPq.isEmpty()) {
	        	answer+=Math.pow(maxPq.poll(), 2);
	        }
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		 int[] works= {4,3,3};
		System.out.println(new Solution().solution(4, works));
	}

}
